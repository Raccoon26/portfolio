package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>