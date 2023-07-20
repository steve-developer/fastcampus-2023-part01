package com.delivery.bootadmin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAdminServer
@SpringBootApplication
class BootadminApplication

fun main(args: Array<String>) {
	runApplication<BootadminApplication>(*args)
}
