package io.github.dragneelfps.kbot.network

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual val DEFAULT_HTTP_CLIENT: HttpClient = HttpClient {
//    install(Logging) {
//        level = LogLevel.BODY
//    }
    install(JsonFeature) {
        serializer = KotlinxSerializer(json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        })
    }
}
