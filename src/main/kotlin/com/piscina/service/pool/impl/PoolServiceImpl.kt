package com.piscina.service.pool.impl

import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import com.piscina.entites.pool.dtos.request.toEntity
import com.piscina.entites.pool.exception.PoolPostException
import com.piscina.repository.PoolRepository
import com.piscina.service.pool.PoolService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.util.*


@Service
class PoolServiceImpl ( val repository: PoolRepository) : PoolService {

    val LOG = LoggerFactory.getLogger(PoolServiceImpl::class.java)

    override fun post(body: RequestPostPoolEntity) {

        LOG.info("START POST Pool body: {}", body)

        runCatching {

            val pool = body.toEntity()

            repository.save(pool)

        }.onFailure {

            LOG.error("ERROR POST Pool body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw PoolPostException(it, HttpStatus.INTERNAL_SERVER_ERROR, "USER_POST_EXCEPTION", "user.post.exception")

        }.onSuccess {

            LOG.info("END POST Pool")

        }
    }
        override fun getAll(): List<PoolEntity> {
        return repository.findAll()

    }

    override fun getById(id: Long) : Optional<PoolEntity> {
        return repository.findById(id)
    }

    override fun update(id: Long, poolEntity: PoolEntity): Optional<PoolEntity>{
    val optional = getById(id)
    if (optional.isEmpty) Optional.empty<PoolEntity>()

    return optional.map {
        val poolToUpdate = it.copy(
            height = poolEntity.height,
            length = poolEntity.length,
            depth = poolEntity.depth
        )
        repository.save(poolToUpdate)
    }}

override fun delete(id: Long) {
    repository.findById(id).map {
        repository.delete(it)
    }.orElseThrow { throw RuntimeException("Id not found $id") }

}
    override fun calculteLiters(poolEntity: PoolEntity): Double {
        val volume = poolEntity.height * poolEntity.length * poolEntity.depth
        return volume * 1000 // Converter para litros
    }




}
