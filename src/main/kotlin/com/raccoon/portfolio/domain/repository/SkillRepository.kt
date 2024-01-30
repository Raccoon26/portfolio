package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.constant.SkillType
import com.raccoon.portfolio.domain.entity.Achievement
import com.raccoon.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long>{

    // select * from skill where lower(name) = lower(:name) and skill_type = :type
    fun findAllByIsActive(isActive: Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<Skill>

}