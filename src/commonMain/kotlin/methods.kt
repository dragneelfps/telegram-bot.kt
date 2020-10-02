package io.github.dragneelfps.kbot

import kotlinx.serialization.Serializable


sealed class Method {
    abstract val id: String
}

@Serializable
class GetUpdates private constructor() : Method() {

    var offset: Int? = null
    var limit: Int? = null
    var timeout: Int? = null
    var allowed_updates: List<String>? = null

    companion object {
        operator fun invoke(block: GetUpdates.() -> Unit) = GetUpdates().apply(block)
    }

    override val id: String = "getUpdates"
}


@Serializable
class SendMessage private constructor(
    val chat_id: Int,
    val text: String,
) : Method() {


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
