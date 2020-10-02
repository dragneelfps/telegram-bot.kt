package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#voice]
 */
@Serializable
data class Voice(
    val file_id: String,
    val file_unique_id: String,
    val duration: Int,
    val mime_type: String? = null,
    val file_size: Int? = null,
)
