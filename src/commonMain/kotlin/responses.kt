package io.nooblabs.kbot

import kotlinx.serialization.Serializable

@Serializable
data class ArrayResponse<T>(
    val ok: Boolean,
    val result: List<T> = emptyList()
)

@Serializable
data class SingleResult<T>(
    val ok: Boolean,
    val result: T
)
