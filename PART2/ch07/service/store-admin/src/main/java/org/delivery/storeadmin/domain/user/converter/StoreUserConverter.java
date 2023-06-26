package org.delivery.storeadmin.domain.user.converter;

import lombok.RequiredArgsConstructor;
import org.delivery.db.store.StoreEntity;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.db.storeuser.StoreUserEntity;
import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreUserConverter {

    public StoreUserEntity toEntity(
        StoreUserRegisterRequest request,
        StoreEntity storeEntity
    ){
        return StoreUserEntity.builder()
            .email(request.getEmail())
            .password(request.getPassword())
            .role(request.getRole())
            .storeId(storeEntity.getId()) // TODO NULL 일때 에러 체크 확인 필요
            .build();
    }

    public StoreUserResponse toResponse(
        StoreUserEntity storeUserEntity,
        StoreEntity storeEntity
    ){
        return StoreUserResponse.builder()
            .user(
                StoreUserResponse.UserResponse.builder()
                    .id(storeUserEntity.getId())
                    .email(storeUserEntity.getEmail())
                    .status(storeUserEntity.getStatus())
                    .role(storeUserEntity.getRole())
                    .registeredAt(storeUserEntity.getRegisteredAt())
                    .unregisteredAt(storeUserEntity.getUnregisteredAt())
                    .lastLoginAt(storeUserEntity.getLastLoginAt())
                    .build()
            )
            .store(
                StoreUserResponse.StoreResponse.builder()
                    .id(storeEntity.getId())
                    .name(storeEntity.getName())
                    .build()
            )
            .build();
    }

    public StoreUserResponse toResponse(UserSession userSession){
        return StoreUserResponse.builder()
            .user(
                StoreUserResponse.UserResponse.builder()
                    .id(userSession.getUserId())
                    .email(userSession.getEmail())
                    .status(userSession.getStatus())
                    .role(userSession.getRole())
                    .registeredAt(userSession.getRegisteredAt())
                    .unregisteredAt(userSession.getUnregisteredAt())
                    .lastLoginAt(userSession.getLastLoginAt())
                    .build()
            )
            .store(
                StoreUserResponse.StoreResponse.builder()
                    .id(userSession.getStoreId())
                    .name(userSession.getStoreName())
                    .build()
            )
            .build();
    }
}
