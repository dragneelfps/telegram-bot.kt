package io.github.dragneelfps.kbot.models

import io.github.dragneelfps.kbot.ArrayResponse
import kotlinx.serialization.Serializable

@Serializable
data class Update(
    val update_id: Int,
    val message: Message? = null
)

val ArrayResponse<Update>.lastUpdateId
    get() = result.lastOrNull()?.update_id
