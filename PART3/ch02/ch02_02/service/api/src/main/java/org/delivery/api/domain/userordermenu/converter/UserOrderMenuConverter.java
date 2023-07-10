package org.delivery.api.domain.userordermenu.converter;

import org.delivery.api.common.annotation.Converter;
import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.db.userorder.UserOrderEntity;
import org.delivery.db.userordermenu.UserOrderMenuEntity;

@Converter
public class UserOrderMenuConverter {

    public UserOrderMenuEntity toEntity(
        UserOrderEntity userOrderEntity,
        StoreMenuEntity storeMenuEntity
    ){
        return UserOrderMenuEntity.builder()
            .userOrderId(userOrderEntity.getId())
            .storeMenuId(storeMenuEntity.getId())
            .build()
            ;
    }

}
