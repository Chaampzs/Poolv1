package com.piscina.entites.pool.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "pool")
data class PoolEntity (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val height: Double,
    val length: Double,
    val depth: Double

)
