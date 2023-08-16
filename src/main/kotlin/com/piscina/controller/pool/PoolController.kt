package com.piscina.controller.pool

import com.piscina.entites.pool.domain.PoolEntity
import com.piscina.entites.pool.dtos.request.RequestDeletePoolEntity
import com.piscina.entites.pool.dtos.request.RequestPostPoolEntity
import com.piscina.entites.pool.dtos.request.RequestPutPoolEntity
import com.piscina.lib.getAuthorization
import com.piscina.lib.getHeaders
import com.piscina.service.auth.AuthService
import com.piscina.service.pool.PoolService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping ("/pool")
class PoolController(val service: PoolService,
                     val request: HttpServletRequest,
                     val authService: AuthService) {
    @PostMapping("/")
    fun post(@RequestBody body: RequestPostPoolEntity): ResponseEntity<HttpStatus> {
        val authorization = request.getHeaders().getAuthorization(true)
        authorization?.let {
            authService.validate("", it)
        }
        service.post(body)
        return ResponseEntity.ok(HttpStatus.OK)
    }
    @PutMapping("/{id}")
    fun update(@RequestBody body: RequestPutPoolEntity, @PathVariable id: String): ResponseEntity<HttpStatus> {

        service.update(body)

        return ResponseEntity.ok(HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@RequestBody body : RequestDeletePoolEntity): ResponseEntity<HttpStatus> {
        service.delete(body)
        return ResponseEntity.ok(HttpStatus.OK)
    }

    @GetMapping
    fun getAll(): List<PoolEntity> = service.getAll()


    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<PoolEntity> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())




    @PostMapping("/calculate/water")
    fun calculateWater(@RequestBody poolEntity: PoolEntity): ResponseEntity<Double> {
        val volumeLiters = service.calculteLiters(poolEntity)
        return ResponseEntity.ok(volumeLiters)
    }

}



