package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#audio]
 */
@Serializable
data class Audio(
    val file_id: String,
    val file_unique_id: String,
    val duration: Int,
    val performer: String? = null,
    val title: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
    val thumb: PhotoSize? = null,
)
