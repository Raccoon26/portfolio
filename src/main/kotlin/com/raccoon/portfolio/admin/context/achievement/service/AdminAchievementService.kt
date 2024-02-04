package com.raccoon.portfolio.admin.context.achievement.service

import com.raccoon.portfolio.admin.data.TableDTO
import com.raccoon.portfolio.domain.entity.Achievement
import com.raccoon.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}