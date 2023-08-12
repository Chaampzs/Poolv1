package com.piscina.controller.handler

import com.piscina.entites.abstract.ApiError
import com.piscina.entites.auth.AuthUnauthorizedException
import com.piscina.entites.pool.exception.PoolPostException
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class PoolHandler(val messageSource: MessageSource) {

    val LOG = LoggerFactory.getLogger(PoolHandler::class.java)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [PoolPostException::class])
    fun handle(e: PoolPostException) : ApiError {
        LOG.error("ERROR POST Pool " + e.message)
        return ApiError(e.httpStatusCode.value(), e.codeMessage, e.message)
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [AuthUnauthorizedException::class])
    fun handle(e: AuthUnauthorizedException) : ApiError {
        LOG.error("ERROR AUTHENTICATE " + e.message)
        return ApiError(e.httpStatusCode.value(), e.codeMessage, e.message)
    }
}