package com.raccoon.portfolio.presentation.dto

import com.raccoon.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}
