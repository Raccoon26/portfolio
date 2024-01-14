package com.raccoon.portfolio.domain.repository

import com.raccoon.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>