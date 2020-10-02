package io.github.dragneelfps.kbot.methods

import io.github.dragneelfps.kbot.ManyResult
import io.github.dragneelfps.kbot.SingleResult
import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.models.Update
import io.github.dragneelfps.kbot.models.User


interface MethodData {
    val id: String
}

interface ClientMethods {

    suspend fun getUpdate(block: GetUpdates.() -> Unit = {}): ManyResult<Update>

    suspend fun getMe(): SingleResult<User>

    suspend fun sendMessage(chat_id: Int, text: String, block: SendMessage.() -> Unit = {}): SingleResult<Message>

    suspend fun forwardMessage(
        chat_id: Int,
        from_chat_id: Int,
        message_id: Int,
        block: ForwardMessage.() -> Unit = {}
    ): SingleResult<Message>

    suspend fun sendPhoto(
        chat_id: Int,
        photo: String,
        block: SendPhoto.() -> Unit = {}
    ): SingleResult<Message>
}
