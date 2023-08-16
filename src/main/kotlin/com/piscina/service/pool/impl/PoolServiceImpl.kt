package com.piscina.service.pool.impl

import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.domain.toEntity
import com.piscina.entites.pool.dtos.request.RequestDeletePoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import com.piscina.entites.pool.dtos.request.RequestPutPoolEntity
import com.piscina.entites.pool.dtos.request.toEntity
import com.piscina.entites.pool.exception.PoolDeleteException
import com.piscina.entites.pool.exception.PoolGetException
import com.piscina.entites.pool.exception.PoolPostException
import com.piscina.entites.pool.exception.PoolPutException
import com.piscina.repository.PoolRepository
import com.piscina.service.pool.PoolService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service


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

            throw PoolPostException(it, HttpStatus.INTERNAL_SERVER_ERROR, "POOL_POST_EXCEPTION", "pool.post.exception")

        }.onSuccess {

            LOG.info("END POST Pool")

        }
    }

    override fun update(body: RequestPutPoolEntity) {
        LOG.info("START PUT Pool body: {}", body)

        runCatching {

            val pool = body.toEntity()

            repository.save(pool)

        }.onFailure {

            LOG.error("ERROR PUT Pool body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw PoolPutException(it, HttpStatus.INTERNAL_SERVER_ERROR, "POOL_PUT_EXCEPTION", "pool.put.exception")

        }.onSuccess {

            LOG.info("END PUT Pool")

        }
    }
    override fun delete(body: RequestDeletePoolEntity) {

        LOG.info("START DELETE Pool body: {}", body)

        runCatching {


        }.onFailure {

            LOG.error("ERROR DELETE Pool body: {} message: {} causeMessage: {}", body, it.message, it.cause!!.message)

            throw PoolDeleteException(
                it,
                HttpStatus.INTERNAL_SERVER_ERROR, "POOL_DELETE_EXCEPTION", "pool.delete.exception"
            )

        }.onSuccess {

            LOG.info("END DELETE Pool")
        }


    }
    override fun getAll() : List<PoolEntity> {

        LOG.info("START GET Pool")

        var response = emptyList<PoolEntity>()

        runCatching {

            response = repository.findAll()

        }.onFailure {

            LOG.error("ERROR GET Pool message: {} causeMessage: {}", it.message, it.cause!!.message)

            throw PoolGetException(it, HttpStatus.INTERNAL_SERVER_ERROR, "POOL_GET_EXCEPTION", "pool.get.exception")

        }.onSuccess {

            LOG.info("END GET Pool response: {}", response.size)

        }

        return response.toEntity()
    }

    override fun getById (id: Long): PoolEntity{

        LOG.info("START GET Pool ", + id)

        var response = getById(id)

        runCatching {

             repository.findById(id);

        }.onFailure {

            LOG.error("ERROR GET Pool message: {} causeMessage: {}", it.message, it.cause!!.message)

            throw PoolGetException(it, HttpStatus.INTERNAL_SERVER_ERROR, "POOL_GET_EXCEPTION", "pool.get.exception")

        }.onSuccess {

            LOG.info("END GET Pool response: {}", response)

        }

        return response.toEntity()
    }

    override fun calculteLiters(poolEntity: PoolEntity): Double {
        val volume = poolEntity.height!! * poolEntity.length!! * poolEntity.depth!!
        return volume * 1000 // Converter para litros
    }






   }
