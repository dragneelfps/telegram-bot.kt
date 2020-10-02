package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#video]
 */
@Serializable
data class Video(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
)
