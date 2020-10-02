package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#location]
 */
@Serializable
data class Location(
    val longitude: Float,
    val latitude: Float,
)
