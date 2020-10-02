package io.github.dragneelfps.kbot.models

import io.github.dragneelfps.kbot.ManyResult
import kotlinx.serialization.Serializable

@Serializable
data class Update(
    val update_id: Int,
    val message: Message? = null
)

val ManyResult<Update>.lastUpdateId
    get() = result.lastOrNull()?.update_id
