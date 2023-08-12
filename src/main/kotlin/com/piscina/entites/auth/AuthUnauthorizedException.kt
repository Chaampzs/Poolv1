package com.piscina.entites.auth

import com.piscina.entites.abstract.AbstractException
import org.springframework.http.HttpStatus

class AuthUnauthorizedException(override val httpStatusCode: HttpStatus = HttpStatus.UNAUTHORIZED,
                                override val codeMessage: String = "ERROR_UNAUTHORIZED",
    //TODO - ARRUMAR MENSAGEM
                                override val message: String = "Falha na autenticação",
                                override val throwable: Throwable? = null) : AbstractException()