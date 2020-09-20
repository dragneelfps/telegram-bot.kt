package io.nooblabs.kbot.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.nooblabs.kbot.ArrayResponse
import io.nooblabs.kbot.GetUpdates
import io.nooblabs.kbot.GetUpdates.GetUpdatesBuilder
import io.nooblabs.kbot.SendMessage
import io.nooblabs.kbot.SendMessage.SendMessageBuilder
import io.nooblabs.kbot.SingleResult
import io.nooblabs.kbot.models.Message
import io.nooblabs.kbot.models.Update

class TClient(
    private val token: String,
    private val httpClient: HttpClient = DEFAULT_HTTP_CLIENT,
    private val endpoint: (String, Any) -> String = DEFAULT_ENDPOINT_BUILDER,
) {

    suspend fun getUpdate(block: GetUpdatesBuilder.() -> Unit = {}): ArrayResponse<Update> {
        val req = GetUpdatesBuilder().apply(block).build()
        return httpClient.post {
            url(endpoint(token, GetUpdates))
            contentType(ContentType.Application.Json)
            body = req
        }
    }

    suspend fun sendMessage(
        chat_id: Long,
        text: String,
        block: SendMessageBuilder.() -> Unit = {}
    ): SingleResult<Message> {
        val req = SendMessageBuilder().apply(block).build(chat_id, text)
        return httpClient.post {
            url(endpoint(token, SendMessage))
            contentType(ContentType.Application.Json)
            body = req
        }
    }
}

val DEFAULT_ENDPOINT_BUILDER = { token: String, method: Any -> "https://api.telegram.org/bot$token/${method}" }

expect val DEFAULT_HTTP_CLIENT: HttpClient
