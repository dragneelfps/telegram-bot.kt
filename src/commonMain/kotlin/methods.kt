package io.github.dragneelfps.kbot

import kotlinx.serialization.Serializable


sealed class Method

@Serializable
class GetUpdates private constructor(
    val offset: Int?,
    val limit: Int?,
    val timeout: Int?,
    val allowed_updates: List<String>?
) : Method() {

    companion object {
        override fun toString() = "getUpdates"
    }

    class GetUpdatesBuilder {
        var offset: Int? = null
        var limit: Int? = null
        var timeout: Int? = null
        var allowed_updates: List<String>? = null

        fun build() = GetUpdates(offset = offset, limit = limit, timeout = timeout, allowed_updates = allowed_updates)
    }
}


@Serializable
class SendMessage private constructor(
    val chat_id: Int,
    val text: String,
    val parse_mode: String?,
    val disable_web_page_preview: Boolean?,
    val disable_notification: Boolean?,
    val reply_to_message_id: Int?
) : Method() {

    companion object {
        override fun toString() = "sendMessage"
    }

    class SendMessageBuilder {
        var parse_mode: String? = "HTML"
        var disable_web_page_preview: Boolean? = null
        var disable_notification: Boolean? = null
        var reply_to_message_id: Int? = null

        fun build(chat_id: Int, text: String) =
            SendMessage(
                chat_id = chat_id,
                text = text,
                parse_mode = parse_mode,
                disable_web_page_preview = disable_web_page_preview,
                disable_notification = disable_notification,
                reply_to_message_id = reply_to_message_id
            )
    }
}
