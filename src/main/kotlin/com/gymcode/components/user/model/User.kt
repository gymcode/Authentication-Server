package com.gymcode.components.user.model

import com.gymcode.core.shared.MODEL_VERSION
import kotlinx.serialization.Contextual
import kotlinx.serialization.Required
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import java.time.LocalDateTime
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
    val password: String? = null,
    val houseAddress: String? = null,
    @Required
    val email: String,
    @Required
    val postalAddress: String,
    @Serializable(with = )
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val updatedDate: LocalDateTime = LocalDateTime.now(),
    val version: Long = MODEL_VERSION
)

@Serializable
data class UserDTO(
    val
)
