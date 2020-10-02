package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#file]
 */
@Serializable
data class File(
    val file_id: String,
    val file_unique_id: String,
    val file_size: Int? = null,
    val file_path: String? = null,
)
