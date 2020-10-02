package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#sticker]
 */
@Serializable
data class Sticker(
    val file_id: String,
    val file_unique_id: String,
    val width: Int,
    val height: Int,
    val is_animated: Boolean,
    val thumb: PhotoSize? = null,
    val emoji: String? = null,
    val set_name: String? = null,
    val mask_position: MaskPosition? = null,
    val file_size: Int? = null,
)

/**
 * [https://core.telegram.org/bots/api#stickerset]
 */
@Serializable
data class StickerSet(
    val name: String,
    val title: String,
    val is_animated: Boolean,
    val contains_masks: Boolean,
    val stickers: List<Sticker>,
    val thumb: PhotoSize? = null,
)

/**
 * [https://core.telegram.org/bots/api#maskposition]
 */
@Serializable
data class MaskPosition(
    val point: String,
    val x_shift: Float,
    val y_shift: Float,
    val scale: Float,
)
