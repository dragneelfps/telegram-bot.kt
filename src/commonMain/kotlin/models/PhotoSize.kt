package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#photosize]
 */
@Serializable
data class PhotoSize(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val file_size: Int? = null,
)
