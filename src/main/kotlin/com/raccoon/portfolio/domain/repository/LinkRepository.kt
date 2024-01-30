package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.entity.Achievement
import com.raccoon.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>{

    fun findAllByIsActive(isActive: Boolean): List<Link>

}