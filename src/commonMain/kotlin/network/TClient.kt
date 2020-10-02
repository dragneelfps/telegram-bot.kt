package io.github.dragneelfps.kbot.network

import io.github.dragneelfps.kbot.*
import io.github.dragneelfps.kbot.models.Message
import io.github.dragneelfps.kbot.models.Update
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
) {

    suspend fun getUpdate(block: GetUpdates.() -> Unit = {}): ArrayResponse<Update> {
        val req = GetUpdates(block)
        return call(req)
    }

    suspend fun sendMessage(
        chat_id: Int,
        text: String,
        block: SendMessage.() -> Unit = {}
    ): SingleResult<Message> {
        val req = SendMessage(chat_id, text, block)
        return call(req)
    }

    private suspend inline fun <reified T : Method, reified V> call(req: T): V {
        return httpClient.post {
            url(endpoint(token, req.id))
            contentType(ContentType.Application.Json)
            body = req
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
