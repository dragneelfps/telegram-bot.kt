package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#callbackquery]
 */
@Serializable
data class CallbackQuery(
    val id: String,
    val user: User,
    val message: Message? = null,
    val inline_message_id: String? = null,
    val chat_instance: String? = null,
    val data: String? = null,
    val game_short_name: String? = null,
)
