package com.piscina.entites.pool.exception

import org.springframework.http.HttpStatus


class PoolPostException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()