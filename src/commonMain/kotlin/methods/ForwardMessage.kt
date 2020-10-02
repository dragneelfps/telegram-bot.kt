package io.github.dragneelfps.kbot.methods

import kotlinx.serialization.Serializable

@Serializable
class ForwardMessage private constructor(val chat_id: Int, val from_chat_id: Int, val message_id: Int) : MethodData {
    var disable_notification: Boolean? = null

    companion object {
        operator fun invoke(chat_id: Int, from_chat_id: Int, message_id: Int, block: ForwardMessage.() -> Unit) =
            ForwardMessage(chat_id, from_chat_id, message_id).apply(block)
    }

    override val id: String = "forwardMessage"
}
