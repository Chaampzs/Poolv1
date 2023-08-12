package com.piscina

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PoolNotFoundException(id: Long) : RuntimeException("Piscina não encontrada com ID: $id")
