package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#animation]
 */
@Serializable
data class Animation(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_name: String? = null,
    val mime_type: String? = null,
    val file_size: Int? = null,
)
