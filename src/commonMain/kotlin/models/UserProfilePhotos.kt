package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#userprofilephotos]
 */
@Serializable
data class UserProfilePhotos(
    val total_count: Int,
    val photos: List<List<PhotoSize>> = emptyList()
)
