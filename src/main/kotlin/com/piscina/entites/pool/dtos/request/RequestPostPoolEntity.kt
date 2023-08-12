package com.piscina.entites.pool.dtos.request

import com.piscina.entites.pool.domain.PoolEntity

class RequestPostPoolEntity (  var id: Long? = null,
                               val height: Double,
                               val length: Double,
                               val depth: Double

)
 fun RequestPostPoolEntity.toEntity() = PoolEntity( id = id, height = height, length = length, depth = depth)
