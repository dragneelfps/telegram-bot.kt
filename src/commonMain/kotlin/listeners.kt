package io.github.dragneelfps.kbot

import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.models.Update
import io.github.dragneelfps.kbot.network.TClient


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


fun ListenerConfig.text(match: Regex, block: suspend (TClient, Message, MatchResult) -> Unit) {
    val regexListener = object : Listener {
        override fun shouldProcess(update: Update) = update.message?.text?.let { match matches it } ?: false

        override suspend fun process(update: Update) {
            block(tClient, update.message!!, match.find(update.message.text!!)!!)
        }
    }
    addListener(listener = regexListener)
}

fun ListenerConfig.text(match: String, block: suspend (TClient, Message, MatchResult) -> Unit) {
    text(match = match.toRegex(), block)
}
