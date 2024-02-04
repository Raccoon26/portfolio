package com.raccoon.portfolio.admin.context.introduction.service

import com.raccoon.portfolio.admin.data.TableDTO
import com.raccoon.portfolio.domain.entity.Introduction
import com.raccoon.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}