package io.github.dragneelfps.kbot.methods

import kotlinx.serialization.Serializable

@Serializable
class GetUpdates private constructor() : MethodData {

    var offset: Int? = null
    var limit: Int? = null
    var timeout: Int? = null
    var allowed_updates: List<String>? = null

    companion object {
        operator fun invoke(block: GetUpdates.() -> Unit) = GetUpdates().apply(block)
    }

    override val id: String = "getUpdates"
}
