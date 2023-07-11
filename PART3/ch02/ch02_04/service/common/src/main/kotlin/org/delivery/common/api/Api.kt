package org.delivery.common.api

data class Api<T>(
    var result: Result?=null,

    var body: T?=null
)