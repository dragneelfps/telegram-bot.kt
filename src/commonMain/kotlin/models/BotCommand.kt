package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#botcommand]
 */
@Serializable
data class BotCommand(
    val command: String,
    val description: String,
)
