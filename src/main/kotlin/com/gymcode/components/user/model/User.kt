package com.gymcode.components.user.model

import com.gymcode.core.shared.MODEL_VERSION
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Serializable
data class User(
    @Contextual
    val uuid: UUID? = null,
    @Required
    val firstName: String,
    @Required
    val lastName: String,
    val otherNames: String? = "",
    @Transient
    val password: String? = "",
    val houseAddress: String? = "",
    @Required
    val email: String,
    @Required
    val postalAddress: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @Serializable(with = LocalDateTimeSerializer::class)
    val updatedDate: LocalDateTime = LocalDateTime.now(),
    val version: Long = MODEL_VERSION
)

@Serializable
data class UserDTO(
    @Required
    val firstName: String,
    @Required
    val lastName: String,
    val otherNames: String?,
    @Required
    val password: String,
    @Required
    val houseAddress: String,
)

@Serializable
data class SignUpDTO(
    @Required
    val email: String,
    @Required
    val password: String
)

class LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    /**
     * The ISO-like date-time formatter that formats or parses a date-time with the offset and zone if available,
     * such as '2011-12-03T10:15:30', '2011-12-03T10:15:30+01:00' or '2011-12-03T10:15:30+01:00[Europe/Paris]'.
     * */
    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(value.format(DateTimeFormatter.ISO_DATE_TIME).toString())
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        val string = decoder.decodeString()
        return LocalDateTime.parse(string)
    }
}
