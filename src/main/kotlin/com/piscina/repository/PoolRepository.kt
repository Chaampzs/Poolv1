package com.piscina.repository

import com.piscina.model.Pool
import org.springframework.data.jpa.repository.JpaRepository

interface PoolRepository : JpaRepository<Pool, Long>
