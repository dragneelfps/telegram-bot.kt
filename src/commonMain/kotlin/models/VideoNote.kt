package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#videonote]
 */
@Serializable
data class VideoNote(
    val file_id: String,
    val file_unique_id: String,
    val length: Int,
    val duration: Int,
    val thumb: PhotoSize? = null,
    val file_size: Int? = null,
)
