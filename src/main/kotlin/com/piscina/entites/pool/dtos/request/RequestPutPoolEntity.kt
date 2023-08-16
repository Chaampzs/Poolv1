package com.piscina.entites.pool.dtos.request

import com.piscina.entites.pool.domain.PoolEntity

class RequestPutPoolEntity(var id: Long? = null,
                    val height: Double? = null,
                    val length: Double? = null,
                    val depth: Double? = null)


fun RequestPutPoolEntity.toEntity() = PoolEntity(
        id = this.id,
        height = this.height,
        length = this.length,
        depth = this.depth)

/*
override fun update(id: Long, poolEntity: PoolEntity): Optional<PoolEntity> {

    val optional = getById(id)
    if (optional.isEmpty) Optional.empty<PoolEntity>()

    return optional.map {
        val poolToUpdate = it.copy(
            height = poolEntity.height,
            length = poolEntity.length,
            depth = poolEntity.depth
        )
        repository.save(poolToUpdate)
    }
}


 */