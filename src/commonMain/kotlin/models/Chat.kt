package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#chat]
 */
@Serializable
data class Chat(
    val id: Long,
    @Serializable(with = ChatTypeAsStringSerializer::class)
    val type: ChatType,
)

enum class ChatType {
    PRIVATE, GROUP, SUPERGROUP, CHANNEL;
}


