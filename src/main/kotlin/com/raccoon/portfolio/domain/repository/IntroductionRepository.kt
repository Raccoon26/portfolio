package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.entity.Achievement
import com.raccoon.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository : JpaRepository<Introduction, Long>{

    //select * from introduction where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Introduction>

}