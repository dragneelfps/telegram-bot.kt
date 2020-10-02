package io.github.dragneelfps.kbot.models

import kotlinx.serialization.Serializable

/**
 * [https://core.telegram.org/bots/api#labeledprice]
 */
@Serializable
data class LabeledPrice(
    val label: String,
    val amount: Int,
)

/**
 * [https://core.telegram.org/bots/api#invoice]
 */
@Serializable
data class Invoice(
    val title: String,
    val description: String,
    val start_parameter: String,
    val currency: String,
    val total_amount: Int,
)

/**
 * [https://core.telegram.org/bots/api#orderinfo]
 */
@Serializable
data class OrderInfo(
    val name: String? = null,
    val phone_number: String? = null,
    val email: String? = null,
    val shipping_address: ShippingAddress? = null,
)

/**
 * [https://core.telegram.org/bots/api#shippingaddress]
 */
@Serializable
data class ShippingAddress(
    val country_code: String,
    val state: String,
    val city: String,
    val street_line1: String,
    val street_line2: String,
    val post_code: String,
)

/**
 * [https://core.telegram.org/bots/api#shippingoption]
 */
@Serializable
data class ShippingOption(
    val id: String,
    val title: String,
    val prices: List<LabeledPrice>,
)

/**
 * [https://core.telegram.org/bots/api#successfulpayment]
 */
@Serializable
data class SuccessfulPayment(
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null,
    val telegram_payment_charge_id: String? = null,
    val provider_payment_charge_id: String? = null,
)

/**
 * [https://core.telegram.org/bots/api#shippingquery]
 */
@Serializable
data class ShippingQuery(
    val id: String,
    val from: User,
    val invoice_payload: String,
    val shipping_address: ShippingAddress,
)

/**
 * [https://core.telegram.org/bots/api#precheckoutquery]
 */
@Serializable
data class PreCheckoutQuery(
    val id: String,
    val from: User,
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    val shipping_option_id: String? = null,
    val order_info: OrderInfo? = null,
)
