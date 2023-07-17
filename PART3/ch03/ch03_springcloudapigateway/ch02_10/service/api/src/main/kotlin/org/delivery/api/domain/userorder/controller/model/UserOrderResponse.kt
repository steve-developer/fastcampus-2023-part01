package org.delivery.api.domain.userorder.controller.model

import org.delivery.db.userorder.enums.UserOrderStatus
import java.math.BigDecimal
import java.time.LocalDateTime

data class UserOrderResponse(
    var id: Long? = null,
    var status: UserOrderStatus? = null,
    var amount: BigDecimal? = null,
    var orderedAt: LocalDateTime? = null,
    var acceptedAt: LocalDateTime? = null,
    var cookingStartedAt: LocalDateTime? = null,
    var deliveryStartedAt: LocalDateTime? = null,
    var receivedAt: LocalDateTime? = null,
)