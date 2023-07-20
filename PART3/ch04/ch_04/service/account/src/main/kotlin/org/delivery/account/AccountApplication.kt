package org.delivery.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AccountApplication

fun main(args: Array<String>){
    runApplication<AccountApplication>(*args)
}