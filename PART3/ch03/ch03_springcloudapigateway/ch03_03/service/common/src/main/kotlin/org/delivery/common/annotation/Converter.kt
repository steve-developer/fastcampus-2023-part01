package org.delivery.common.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Service


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Service
annotation class Converter(
    @get:AliasFor(annotation = Service::class)
    val value: String = ""
)
