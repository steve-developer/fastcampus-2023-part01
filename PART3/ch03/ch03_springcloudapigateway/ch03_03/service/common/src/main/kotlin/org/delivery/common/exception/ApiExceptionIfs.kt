package org.delivery.common.exception

import org.delivery.common.error.ErrorCodeIfs

interface ApiExceptionIfs {
    val errorCodeIfs: ErrorCodeIfs?
    val errorDescription: String?
}