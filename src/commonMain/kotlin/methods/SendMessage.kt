package io.github.dragneelfps.kbot.methods

import kotlinx.serialization.Serializable

@Serializable
class SendMessage private constructor(
    val chat_id: Int,
    val text: String,
) : MethodData {


    var parse_mode: String = "HTML"
    var disable_web_page_preview: Boolean? = null
    var disable_notification: Boolean? = null
    var reply_to_message_id: Int? = null

    companion object {
        operator fun invoke(chat_id: Int, text: String, block: SendMessage.() -> Unit) =
            SendMessage(chat_id, text).apply(block)
    }

    override val id: String = "sendMessage"
}
