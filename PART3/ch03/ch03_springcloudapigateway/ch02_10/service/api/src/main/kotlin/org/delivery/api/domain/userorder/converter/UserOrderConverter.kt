package org.delivery.api.domain.userorder.converter

import org.delivery.api.domain.user.model.User
import org.delivery.api.domain.userorder.controller.model.UserOrderResponse
import org.delivery.common.annotation.Converter
import org.delivery.db.store.StoreEntity
import org.delivery.db.storemenu.StoreMenuEntity
import org.delivery.db.userorder.UserOrderEntity

@Converter
class UserOrderConverter {

    fun toEntity(
        user: User?,
        storeEntity: StoreEntity?,
        storeMenuEntityList: List<StoreMenuEntity>?
    ): UserOrderEntity {
        val totalAmount = storeMenuEntityList
            ?.mapNotNull { it -> it.amount }
            ?.reduce { acc, bigDecimal -> acc.add(bigDecimal) }

        return UserOrderEntity(
            userId = user?.id,
            store = storeEntity,
            amount = totalAmount,
        )
    }

    fun toResponse(
        userOrderEntity: UserOrderEntity?
    ): UserOrderResponse {
        return UserOrderResponse(
            id = userOrderEntity?.id,
            status = userOrderEntity?.status,
            amount = userOrderEntity?.amount,
            orderedAt = userOrderEntity?.orderedAt,
            acceptedAt = userOrderEntity?.acceptedAt,
            cookingStartedAt = userOrderEntity?.cookingStartedAt,
            deliveryStartedAt = userOrderEntity?.deliveryStartedAt,
            receivedAt = userOrderEntity?.receivedAt
        )
    }

}