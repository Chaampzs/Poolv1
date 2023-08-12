package com.piscina.controller.pool

import com.piscina.lib.getAuthorization
import com.piscina.lib.getHeaders
import com.piscina.service.auth.AuthService
import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import com.piscina.service.pool.PoolService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping ("/pool")
class PoolController(val service: PoolService,
                     val request: HttpServletRequest,
                     val authService: AuthService
) {
    @PostMapping("/v1")
    fun post(@RequestBody body: RequestPostPoolEntity): ResponseEntity<HttpStatus> {


        val authorization = request.getHeaders().getAuthorization(true)

        authorization?.let {
            authService.validate("", it)
        }

        service.post(body)

        return ResponseEntity.ok(HttpStatus.OK)
    }

   // @PostMapping
   // @ResponseStatus(HttpStatus.CREATED)
  //  fun create(@RequestBody poolEntity: PoolEntity): PoolEntity = service.create(poolEntity)

    @GetMapping
    fun getAll(): List<PoolEntity> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<PoolEntity> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody poolEntity: PoolEntity): ResponseEntity<PoolEntity> =
        service.update(id, poolEntity).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
    @PostMapping("/calculate/water")
    fun calculateWater(@RequestBody poolEntity: PoolEntity): ResponseEntity<Double> {
        val volumeLiters = service.calculteLiters(poolEntity)
        return ResponseEntity.ok(volumeLiters)
    }


}



