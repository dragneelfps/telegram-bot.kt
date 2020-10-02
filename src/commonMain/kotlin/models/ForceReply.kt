package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#forcereply]
 */
@Serializable
data class ForceReply(
    val force_reply: Boolean,
    val selective: Boolean? = null,
)
