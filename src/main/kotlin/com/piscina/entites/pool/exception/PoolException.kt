package com.piscina.entites.pool.exception

import org.springframework.http.HttpStatus


class PoolPostException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()
class PoolDeleteException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()

class PoolPutException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()

class PoolGetException(val exception: Throwable, val httpStatusCode: HttpStatus, val codeMessage: String, val messageProperty: String) : RuntimeException()