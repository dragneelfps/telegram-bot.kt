package io.nooblabs.kbot.models

import io.nooblabs.kbot.ArrayResponse
import kotlinx.serialization.Serializable

@Serializable
data class Update(
    val update_id: Long,
    val message: Message? = null
)

val ArrayResponse<Update>.lastUpdateId
    get() = result.lastOrNull()?.update_id
