package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * https://core.telegram.org/bots/api#passportdata
 */
@Serializable
data class PassportData(
    val data: List<EncryptedPassportElement> = emptyList(),
    val credentials: EncryptedCredentials,
)

/**
 * [https://core.telegram.org/bots/api#encryptedpassportelement]
 */
@Serializable
data class EncryptedPassportElement(
    val type: String,
    val data: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val files: List<PassportFile> = emptyList(),
    val front_side: PassportFile? = null,
    val reverse_side: PassportFile? = null,
    val selfie: PassportFile? = null,
    val translation: List<PassportFile> = emptyList(),
    val hash: String,
)

/**
 * [https://core.telegram.org/bots/api#encryptedcredentials]
 */
@Serializable
data class EncryptedCredentials(
    val data: String,
    val hash: String,
    val secret: String,
)

/**
 * [https://core.telegram.org/bots/api#passportfile]
 */
@Serializable
data class PassportFile(
    val file_id: String,
    val file_unique_id: String,
    val file_size: Int,
    val file_date: Int,
)

/**
 * [https://core.telegram.org/bots/api#passportelementerror]
 */
typealias PassportElementError = JsonElement
