package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#loginurl]
 */
@Serializable
data class LoginUrl(
    val url: String,
    val forward_text: String? = null,
    val bot_username: String? = null,
    val request_write_access: Boolean? = null,
)
