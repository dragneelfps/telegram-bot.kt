package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#user]
 */
@Serializable
data class User(
    val id: Int,
    val is_bot: Boolean,
    val first_name: String,
)
