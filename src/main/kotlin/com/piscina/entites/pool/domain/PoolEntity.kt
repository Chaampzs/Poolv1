package com.piscina.entites.pool.domain

import org.apache.tomcat.jni.Pool
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "pool")
class PoolEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val height: Double?,
    val length: Double?,
    val depth: Double?

)
fun PoolEntity.toEntity() = PoolEntity(id = id,
     height = height,
    length = length,
    depth = depth,
)
fun List<PoolEntity>.toEntity() = map { it.toEntity() }


