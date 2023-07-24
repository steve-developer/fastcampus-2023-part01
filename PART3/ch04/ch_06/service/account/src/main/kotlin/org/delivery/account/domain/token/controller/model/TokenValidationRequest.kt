package org.delivery.account.domain.token.controller.model

import org.delivery.account.domain.token.model.TokenDto

data class TokenValidationRequest(
    var tokenDto: TokenDto?=null
)
