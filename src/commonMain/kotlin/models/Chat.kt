package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#chat]
 */
@Serializable
data class Chat(
    val id: Int,
    val type: String,
    val title: String? = null,
    val username: String? = null,
    val first_name: String? = null,
    val last_name: String? = null,
    val photo: ChatPhoto? = null,
    val description: String? = null,
    val invite_link: String? = null,
    val pinned_message: Message? = null,
    val permissions: ChatPermissions? = null,
    val slow_mode_delay: Int? = null,
    val sticker_set_name: String? = null,
    val can_set_sticker_set: Boolean? = null,
)

enum class ChatType {
    PRIVATE, GROUP, SUPERGROUP, CHANNEL;
}

/**
 * [https://core.telegram.org/bots/api#chatphoto]
 */
@Serializable
data class ChatPhoto(
    val small_file_id: String,
    val small_file_unique_id: String,
    val big_file_id: String,
    val big_file_unique_id: String,
)

/**
 * [https://core.telegram.org/bots/api#chatpermissions]
 */
@Serializable
data class ChatPermissions(
    val can_send_messages: Boolean? = null,
    val can_send_media_messages: Boolean? = null,
    val can_send_polls: Boolean? = null,
    val can_send_other_messages: Boolean? = null,
    val can_add_web_page_previews: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_pin_messages: Boolean? = null,
)

/**
 * [https://core.telegram.org/bots/api#chatmember]
 */
@Serializable
data class ChatMember(
    val user: User,
    val status: String,
    val custom_title: String? = null,
    val until_date: Int? = null,
    val can_be_edited: Boolean? = null,
    val can_post_messages: Boolean? = null,
    val can_edit_messages: Boolean? = null,
    val can_delete_messages: Boolean? = null,
    val can_restrict_messages: Boolean? = null,
    val can_promote_messages: Boolean? = null,
    val can_change_info: Boolean? = null,
    val can_invite_users: Boolean? = null,
    val can_pin_messages: Boolean? = null,
    val is_member: Boolean? = null,
    val can_send_messages: Boolean? = null,
    val can_send_media_messages: Boolean? = null,
    val can_send_polls: Boolean? = null,
    val can_send_other_messages: Boolean? = null,
    val can_add_web_page_previews: Boolean? = null,
)

