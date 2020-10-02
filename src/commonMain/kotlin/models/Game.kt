package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#game]
 */
@Serializable
data class Game(
    val title: String,
    val description: String,
    val photo: List<PhotoSize>,
    val text: String? = null,
    val text_entities: List<MessageEntity> = emptyList(),
    val animation: Animation? = null
)

/**
 * [https://core.telegram.org/bots/api#callbackgame]
 */
@Serializable
data class CallbackGame(val nothing: String? = null)

/**
 * [https://core.telegram.org/bots/api#gamehighscore]
 */
@Serializable
data class GameHighScore(
    val position: Int,
    val user: User,
    val score: Int
)
