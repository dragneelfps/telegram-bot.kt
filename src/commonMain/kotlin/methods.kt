package io.nooblabs.kbot

import kotlinx.serialization.Serializable


sealed class Method

@Serializable
class GetUpdates private constructor(
    val offset: Long?,
    val limit: Long?,
    val timeout: Long?,
    val allowed_updates: List<String>?
) : Method() {

    companion object {
        override fun toString() = "getUpdates"
    }

    class GetUpdatesBuilder {
        var offset: Long? = null
        var limit: Long? = null
        var timeout: Long? = null
        var allowed_updates: List<String>? = null

        fun build() = GetUpdates(offset = offset, limit = limit, timeout = timeout, allowed_updates = allowed_updates)
    }
}


@Serializable
class SendMessage private constructor(
    val chat_id: Long,
    val text: String,
    val parse_mode: String?,
    val disable_web_page_preview: Boolean?,
    val disable_notification: Boolean?,
    val reply_to_message_id: Long?
) : Method() {

    companion object {
        override fun toString() = "sendMessage"
    }

    class SendMessageBuilder {
        var parse_mode: String? = "HTML"
        var disable_web_page_preview: Boolean? = null
        var disable_notification: Boolean? = null
        var reply_to_message_id: Long? = null

        fun build(chat_id: Long, text: String) =
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
