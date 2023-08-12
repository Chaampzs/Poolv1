package com.piscina.service

import com.piscina.PoolNotFoundException
import com.piscina.model.Pool
import com.piscina.repository.PoolRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class PoolServiceImpl (private val repository: PoolRepository) : PoolService{

    override fun create(pool: Pool): Pool{
        //Assert.hasLength(account.name,"[nome] não pode estar em branco!")
        return repository.save(pool)
    }

    override fun getAll(): List<Pool> {
        return repository.findAll()

    }

    override fun getById(id: Long) : Optional<Pool> {
        return repository.findById(id)
    }

    override fun update(id: Long, pool: Pool): Optional<Pool>{
    val optional = getById(id)
    if (optional.isEmpty) Optional.empty<Pool>()

    return optional.map {
        val poolToUpdate = it.copy(
            height = pool.height,
            length = pool.length,
            depth = pool.depth
        )
        repository.save(poolToUpdate)
    }}

override fun delete(id: Long) {
    repository.findById(id).map {
        repository.delete(it)
    }.orElseThrow { throw RuntimeException("Id not found $id") }

}
    override fun calcularVolume(pool: Pool): Double {
        val volume = pool.height * pool.length * pool.depth
        return volume * 1000 // Converter para litros
    }
}
