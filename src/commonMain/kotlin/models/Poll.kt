package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#poll]
 */
@Serializable
data class Poll(
    val id: String,
    val question: String,
    val options: List<PollOption>,
    val total_voter_count: Int,
    val is_closed: Boolean,
    val is_anonymous: Boolean,
    val type: String,
    val allows_multiple_answers: Boolean,
    val correct_option_id: Int? = null,
    val explanation: String? = null,
    val explanation_entities: List<MessageEntity> = emptyList(),
    val open_period: Int? = null,
    val close_date: Int? = null,
)

/**
 * [https://core.telegram.org/bots/api#polloption]
 */
@Serializable
data class PollOption(
    val text: String,
    val voter_count: Int,
)

/**
 * [https://core.telegram.org/bots/api#pollanswer]
 */
@Serializable
data class PollAnswer(
    val poll_id: String,
    val user: User,
    val option_ids: List<Int> = emptyList(),
)
