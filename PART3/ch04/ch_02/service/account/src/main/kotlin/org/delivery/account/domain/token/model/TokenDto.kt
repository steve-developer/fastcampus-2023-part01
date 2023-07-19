package org.delivery.account.domain.token.model

import java.time.LocalDateTime

data class TokenDto(
    var token: String?=null,
    var expiredAt: LocalDateTime?=null
)
