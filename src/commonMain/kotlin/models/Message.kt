package io.nooblabs.kbot.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#message]
 */
@Serializable
data class Message(
    val message_id: Long,
    val from: User? = null,
    @Serializable(with = InstantAsLongSerializer::class)
    val date: Instant,
    val chat: Chat? = null,
    val forward_from: User? = null,
    val forward_from_chat: Chat? = null,
    val forward_from_message_id: Long? = null,
    val forward_signature: String? = null,
    val forward_sender_name: String? = null,
    val forward_date: String? = null,
    val reply_to_message: Message? = null,
    val via_bot: User? = null,
    val edit_date: Long? = null,
    val media_group_id: String? = null,
    val author_signature: String? = null,
    val text: String? = null,
    val entities: List<MessageEntity> = emptyList(),
)
