package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#venue]
 */
@Serializable
data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquare_id: String? = null,
    val foursquare_type: String? = null,
)
