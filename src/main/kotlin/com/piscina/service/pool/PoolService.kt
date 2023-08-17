package com.piscina.service.pool

import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.dtos.request.RequestDeletePoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import com.piscina.entites.pool.dtos.request.RequestPutPoolEntity
import java.util.*

interface PoolService {

    fun post( body: RequestPostPoolEntity)

    fun update(body: RequestPutPoolEntity)

    fun delete(body: RequestDeletePoolEntity)

    fun calculteLiters(poolEntity: PoolEntity): Double

    fun getAll(): List <PoolEntity>

    fun get( id: Long) : PoolEntity


}