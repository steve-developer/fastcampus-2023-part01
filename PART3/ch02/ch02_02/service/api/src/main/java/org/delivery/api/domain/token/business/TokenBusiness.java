package org.delivery.api.domain.token.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.token.converter.TokenConverter;
import org.delivery.api.domain.token.service.TokenService;
import org.delivery.db.user.UserEntity;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;
    private final TokenConverter tokenConverter;

    /**
     * 1. user entity user Id 추출
     * 2. access, refresh token 발행
     * 3. converter -> token response로 변경
     */
    public TokenResponse issueToken(UserEntity userEntity){

        return Optional.ofNullable(userEntity)
            .map(ue -> {
                return ue.getId();
            })
            .map(userId -> {
                var accessToken = tokenService.issueAccessToken(userId);
                var refreshToken = tokenService.issueRefreshToken(userId);
                return tokenConverter.toResponse(accessToken, refreshToken);
            })
            .orElseThrow(
                ()-> new ApiException(ErrorCode.NULL_POINT)
            );
    }

    public Long validationAccessToken(String accessToken){
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }

}
