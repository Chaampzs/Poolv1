package com.piscina.controller

import com.piscina.model.Pool
import com.piscina.service.PoolService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/pool")
class PoolController (private val service: PoolService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody pool: Pool): Pool = service.create(pool)

    @GetMapping
    fun getAll(): List<Pool> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Pool> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody pool: Pool): ResponseEntity<Pool> =
        service.update(id, pool).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
    @PostMapping("/calcular/agua")
    fun calcularAgua(@RequestBody pool: Pool): ResponseEntity<Double> {
        val volumeLitros = service.calcularVolume(pool)
        return ResponseEntity.ok(volumeLitros)
    }
}



