package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable


interface ReplyMarkup

/**
 * [https://core.telegram.org/bots/api#replykeyboardmarkup]
 */
@Serializable
data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val resize_keyboard: Boolean? = null,
    val one_time_keyboard: Boolean? = null,
    val selective: Boolean? = null,
): ReplyMarkup

/**
 * [https://core.telegram.org/bots/api#keyboardbutton]
 */
@Serializable
data class KeyboardButton(
    val text: String,
    val request_contact: Boolean? = null,
    val request_location: Boolean? = null,
    val request_poll: KeyboardButtonPollType? = null,
)

/**
 * [https://core.telegram.org/bots/api#keyboardbuttonpolltype]
 */
@Serializable
data class KeyboardButtonPollType(
    val type: String? = null,
)

/**
 * [https://core.telegram.org/bots/api#replykeyboardremove]
 */
@Serializable
data class ReplyKeyboardRemove(
    val remove_keyboard: Boolean,
    val selective: Boolean? = null,
): ReplyMarkup

/**
 * [https://core.telegram.org/bots/api#inlinekeyboardmarkup]
 */
@Serializable
data class InlineKeyboardMarkup(
    val inline_keyboard: List<List<InlineKeyboardButton>> = emptyList()
): ReplyMarkup

/**
 * [https://core.telegram.org/bots/api#inlinekeyboardbutton]
 */
@Serializable
data class InlineKeyboardButton(
    val text: String,
    val url: String? = null,
    val login_url: LoginUrl? = null,
    val callback_data: String? = null,
    val switch_inline_query: String? = null,
    val switch_inline_query_current_chat: String? = null,
    val callback_game: CallbackGame? = null,
    val pay: String? = null,
)

/**
 * [https://core.telegram.org/bots/api#forcereply]
 */
@Serializable
data class ForceReply(
    val force_reply: Boolean,
    val selective: Boolean? = null,
): ReplyMarkup
