package com.delivery.apigw

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiGwApplication {
}

fun main(args: Array<String>){
    runApplication<ApiGwApplication>(*args)
}