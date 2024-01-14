package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>