package com.piscina.repository

import com.piscina.entites.pool.domain.PoolEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PoolRepository : JpaRepository<PoolEntity, Long>
