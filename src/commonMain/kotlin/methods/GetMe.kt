package io.github.dragneelfps.kbot.methods

import kotlinx.serialization.Serializable

@Serializable
object GetMe : MethodData {
    override val id: String = "getMe"
}
