package io.github.dragneelfps.kbot.models

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


object InstantAsLongSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder) = Instant.fromEpochSeconds(decoder.decodeLong())

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeLong(value.toEpochMilliseconds())
    }
}

object ChatTypeAsStringSerializer : KSerializer<ChatType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ChatType", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder) = ChatType.valueOf(decoder.decodeString().toUpperCase())

    override fun serialize(encoder: Encoder, value: ChatType) {
        encoder.encodeString(value.name.toLowerCase())
    }
}

object MessageEntityTypeAsStringSerializer : KSerializer<MessageEntityType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MessageEntityType", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder) = MessageEntityType.valueOf(decoder.decodeString().toUpperCase())

    override fun serialize(encoder: Encoder, value: MessageEntityType) {
        encoder.encodeString(value.name.toLowerCase())
    }
}
