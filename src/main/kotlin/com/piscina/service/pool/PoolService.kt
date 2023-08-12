package com.piscina.service.pool

import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import java.util.*

interface PoolService {

    fun post( body: RequestPostPoolEntity)

    fun getAll(): List <PoolEntity>

    fun getById( id: Long) : Optional<PoolEntity>

    fun update(id: Long, poolEntity: PoolEntity) : Optional<PoolEntity>

    fun delete(id: Long)

    fun calculteLiters(poolEntity: PoolEntity): Double

}