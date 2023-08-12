package com.piscina.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "pool")
data class Pool (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val height: Double,
    val length: Double,
    val depth: Double

)
