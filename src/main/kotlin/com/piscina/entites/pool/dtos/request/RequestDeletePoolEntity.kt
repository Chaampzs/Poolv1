package com.piscina.entites.pool.dtos.request



class RequestDeletePoolEntity (val pool: DeletePoolEntity)

class DeletePoolEntity(val id: List<Long> = emptyList(),
                       )