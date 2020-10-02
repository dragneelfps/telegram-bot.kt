package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#dice]
 */
@Serializable
data class Dice(
    val emoji: String,
    val value: Int,
)
