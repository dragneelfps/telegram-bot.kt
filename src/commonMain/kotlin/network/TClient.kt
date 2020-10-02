package io.github.dragneelfps.kbot.network

import io.github.dragneelfps.kbot.ManyResult
import io.github.dragneelfps.kbot.SingleResult
import io.github.dragneelfps.kbot.methods.*
import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.models.Update
import io.github.dragneelfps.kbot.models.User
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class TClient(
    private val token: String,
    private val logApiRequests: Boolean,
    private val httpClient: HttpClient = createHttpClient(logApiRequests),
    private val endpoint: (String, Any) -> String = DEFAULT_ENDPOINT_BUILDER,
) : ClientMethods {

    override suspend fun getUpdate(block: GetUpdates.() -> Unit): ManyResult<Update> = GetUpdates(block).call()

    override suspend fun getMe(): SingleResult<User> = GetMe.call()

    override suspend fun sendMessage(
        chat_id: Int,
        text: String,
        block: SendMessage.() -> Unit
    ): SingleResult<Message> = SendMessage(chat_id, text, block).call()

    override suspend fun forwardMessage(
        chat_id: Int,
        from_chat_id: Int,
        message_id: Int,
        block: ForwardMessage.() -> Unit
    ): SingleResult<Message> = ForwardMessage(chat_id, from_chat_id, message_id, block).call()

    override suspend fun sendPhoto(chat_id: Int, photo: String, block: SendPhoto.() -> Unit): SingleResult<Message> =
        SendPhoto(chat_id, photo, block).call()

    private suspend inline fun <reified V> MethodData.call(): V {
        return httpClient.post {
            url(endpoint(token, id))
            contentType(ContentType.Application.Json)
            body = this@call
        }
    }
}

private val DEFAULT_ENDPOINT_BUILDER = { token: String, method: Any -> "https://api.telegram.org/bot$token/${method}" }

private fun createHttpClient(logApiRequests: Boolean) = HttpClient {
    if (logApiRequests) {
        install(Logging) {
            level = LogLevel.BODY
        }
    }
    install(JsonFeature) {
        serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        })
    }
}
