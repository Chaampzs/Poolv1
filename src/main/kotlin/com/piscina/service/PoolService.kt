package com.piscina.service

import com.piscina.model.Pool
import java.util.*

interface PoolService {

    fun create ( pool: Pool): Pool

    fun getAll(): List <Pool>

    fun getById( id: Long) : Optional<Pool>

    fun update( id: Long,  pool: Pool) : Optional<Pool>

    fun delete(id: Long)

    fun calcularVolume(pool: Pool): Double

}