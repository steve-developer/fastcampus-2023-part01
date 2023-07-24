package com.delivery.apigw.exceptionhandler

import com.delivery.apigw.common.Log
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class GlobalExceptionHandler(
    val objectMapper: ObjectMapper
): ErrorWebExceptionHandler {

    data class ErrorResponse(val error: String)

    companion object: Log

    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> {
        log.error("global error exception url : {}", exchange.request.uri, ex)

        val response = exchange.response
        if(response.isCommitted){
            return Mono.error(ex)
        }

        response.headers.contentType = MediaType.APPLICATION_JSON

        val errorResponseByteArray = ErrorResponse(
            error = ex.localizedMessage
        ).run {
            objectMapper.writeValueAsBytes(this)
        }

        val dataBuffer = response.bufferFactory()

        return response.writeWith(
            Mono.fromSupplier {
                dataBuffer.wrap(errorResponseByteArray)
            }
        )
    }
}