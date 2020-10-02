package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * [https://core.telegram.org/bots/api#inlinequery]
 */
@Serializable
data class InlineQuery(
    val id: String,
    val from: User,
    val location: Location? = null,
    val query: String,
    val offset: String,
)

/**
 * [https://core.telegram.org/bots/api#inlinequeryresult]
 */
typealias InlineQueryResult = JsonElement

/**
 * [https://core.telegram.org/bots/api#inputmessagecontent]
 */
typealias InlineMessageContent = JsonElement

/**
 * [https://core.telegram.org/bots/api#choseninlineresult]
 */
@Serializable
data class ChosenInlineResult(
    val result_id: String,
    val from: User,
    val location: Location? = null,
    val inline_message_id: String? = null,
    val query: String,
)
