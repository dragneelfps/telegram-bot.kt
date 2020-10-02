package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * [https://core.telegram.org/bots/api#inputmedia]
 */
sealed class InputMedia

/**
 * [https://core.telegram.org/bots/api#inputmediaanimation]
 */
@Serializable
data class InputMediaAnimation(
    val type: String,
    val media: String,
    val thumb: InputFile? = null, // TODO: 10/2/2020 Support both InputFile and String
    val caption: String? = null,
    val parse_mode: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,
) : InputMedia()

/**
 * [https://core.telegram.org/bots/api#inputmediaaudio]
 */
@Serializable
data class InputMediaAudio(
    val type: String,
    val media: String,
    val thumb: InputFile? = null, // TODO: 10/2/2020 Support both InputFile and String
    val caption: String? = null,
    val parse_mode: String? = null,
    val duration: Int? = null,
    val performer: String? = null,
    val title: String? = null,
) : InputMedia()

/**
 * [https://core.telegram.org/bots/api#inputmediadocument]
 */
@Serializable
data class InputMediaDocument(
    val type: String,
    val media: String,
    val thumb: InputFile? = null, // TODO: 10/2/2020 Support both InputFile and String
    val caption: String? = null,
    val parse_mode: String? = null,
) : InputMedia()


/**
 * [https://core.telegram.org/bots/api#inputmediaphoto]
 */
@Serializable
data class InputMediaPhoto(
    val type: String,
    val media: String,
    val caption: String? = null,
    val parse_mode: String? = null,
) : InputMedia()

/**
 * [https://core.telegram.org/bots/api#inputmediavideo]
 */
@Serializable
data class InputMediaVideo(
    val type: String,
    val media: String,
    val thumb: InputFile? = null, // TODO: 10/2/2020 Support both InputFile and String
    val caption: String? = null,
    val parse_mode: String? = null,
    val width: Int? = null,
    val height: Int? = null,
    val duration: Int? = null,
    val supports_streaming: Boolean? = null,
) : InputMedia()

/**
 * [https://core.telegram.org/bots/api#inputfile]
 */
typealias InputFile = JsonElement // TODO: 10/2/2020 can we handle it better?

