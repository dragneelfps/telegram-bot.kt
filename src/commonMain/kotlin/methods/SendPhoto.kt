package io.github.dragneelfps.kbot.methods

import io.github.dragneelfps.kbot.models.ReplyMarkup
import kotlinx.serialization.Serializable

@Serializable
class SendPhoto(val chat_id: Int, val photo: String) : MethodData {

    var caption: String? = null
    var parse_mode: String? = null
    var disable_notification: Boolean? = null
    var reply_to_message_id: Int? = null
    var replyMarkup: ReplyMarkup? = null

    override val id: String = "sendPhoto"

    companion object {
        operator fun invoke(chat_id: Int, photo: String, block: SendPhoto.() -> Unit) =
            SendPhoto(chat_id, photo).apply(block)
    }
}
