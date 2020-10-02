package io.github.dragneelfps.kbot.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.github.dragneelfps.kbot.ArrayResponse
import io.github.dragneelfps.kbot.GetUpdates
import io.github.dragneelfps.kbot.GetUpdates.GetUpdatesBuilder
import io.github.dragneelfps.kbot.SendMessage
import io.github.dragneelfps.kbot.SendMessage.SendMessageBuilder
import io.github.dragneelfps.kbot.SingleResult
import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.models.Update

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
        chat_id: Int,
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

val DEFAULT_HTTP_CLIENT: HttpClient = HttpClient {
//    install(Logging) {
//        level = LogLevel.BODY
//    }
    install(JsonFeature) {
        serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        })
    }
}
