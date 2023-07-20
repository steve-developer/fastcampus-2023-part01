package org.delivery.api

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiApplication

fun main(args: Array<String>){
    runApplication<ApiApplication>(*args)
}