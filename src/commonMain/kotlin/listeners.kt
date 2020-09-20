package io.nooblabs.kbot

import io.nooblabs.kbot.models.Update
import io.nooblabs.kbot.network.TClient


interface Listener {
    fun shouldProcess(update: Update): Boolean
    suspend fun process(update: Update)
}

fun ListenerConfig.generic(block: suspend (TClient, Update) -> Unit) {
    val genericListener = object : Listener {
        override fun shouldProcess(update: Update) = true

        override suspend fun process(update: Update) {
            block(tClient, update)
        }
    }
    addListener(listener = genericListener)
}
