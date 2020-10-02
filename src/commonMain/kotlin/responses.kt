package io.github.dragneelfps.kbot

import kotlinx.serialization.Serializable

@Serializable
data class ManyResult<T>(
    val ok: Boolean,
    val result: List<T> = emptyList()
)

@Serializable
data class SingleResult<T>(
    val ok: Boolean,
    val result: T
)
