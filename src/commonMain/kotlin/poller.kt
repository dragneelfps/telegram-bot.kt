package io.github.dragneelfps.kbot

import io.github.dragneelfps.kbot.models.Update
import io.github.dragneelfps.kbot.models.lastUpdateId
import io.github.dragneelfps.kbot.network.TClient
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class Poller(
    private val tClient: TClient,
    private val pollDelaySeconds: Long,
    private val listeners: List<Listener> = emptyList()
) {
    private var job: Job? = null
    private var updateId: Int = 0

    suspend fun startPolling() {
        cancelPollingIfRunning()
        coroutineScope {
            job = launch {
                getUpdates()
                    .onEach {
                        processUpdate(it)
                    }
                    .collect()
            }
        }
    }

    fun stopPolling() {
        cancelPollingIfRunning()
    }

    private fun cancelPollingIfRunning() {
        job?.cancel()
    }

    private suspend fun processUpdate(updates: ArrayResponse<Update>) {
        updates.result.forEach { update ->
            listeners.filter { it.shouldProcess(update) }
                .forEach { it.process(update) }
        }
    }

    private fun getUpdates() = flow {
        while (true) {
            val updateRes = tClient.getUpdate {
                offset = updateId
            }
            updateId = updateRes.lastUpdateId?.plus(1) ?: updateId
            emit(updateRes)
            delay(pollDelaySeconds * 1000)
        }
    }

    companion object {
        const val DEFAULT_POLL_DELAY_SECONDS = 5L
    }
}
