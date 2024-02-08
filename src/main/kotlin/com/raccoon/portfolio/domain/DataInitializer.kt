package com.raccoon.portfolio.domain

import com.raccoon.portfolio.domain.constant.SkillType
import com.raccoon.portfolio.domain.entity.*
import com.raccoon.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class   DataInitializer(
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository,
        private val accountRepository: AccountRepository
) {

    @PostConstruct
    fun initializeData(){

        println("Spring run, Initializing data")

        val achievements = mutableListOf<Achievement>(
                Achievement(
                        title = "2021 Hacking contest Prize",
                        description = "Jeopardy, Attack-Defence, Hack-quest",
                        host = "CTFtime",
                        achievedDate = LocalDate.of(2021, 8, 1),
                        isActive = true
                ),
                Achievement(
                        title = "CCNA",
                        description = "Network, IP, Security",
                        host = "Cisco",
                        achievedDate = LocalDate.of(2018, 10, 2),
                        isActive = true
                )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
                Introduction(content = "a developer who takes the initiative in finding and solving problems. ", isActive = true),
                Introduction(content = "It pursues skills that interest people, not skills for technology. ", isActive = true),
                Introduction(content = "I like the work of refactoring existing sources and improving them to a better structure. ", isActive = true),
                Introduction(content = "33raccoon33@gmail.com", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
                Link(name = "Github", content = "https://github.com/Raccoon26", isActive = true),
                Link(name = "Linkedin", content = "https://www.linkedin.com/in/chanhyeok-shin-85640621b/", isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
                title = "Wonkwang University",
                description = "Computer Software Engineering",
                startYear = 2018,
                startMonth = 2,
                endYear = 2024,
                endMonth = 2,
                isActive = true
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "Computer Study Club Management", isActive = true),
                        ExperienceDetail(content = "Game Server Study", isActive = true)
                )
        )
        val experience2 = Experience(
                title = "Paper Village",
                description = "Unity Game Server Developer",
                startYear = 2020,
                startMonth = 9,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        experience2.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "C#, RUST based game server development", isActive = true),
                        ExperienceDetail(content = "Entity Framework Core development", isActive = true)
                )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        //skill 초기화
        val c = Skill(name = "C#", type = SkillType.LANGUAGE.name, isActive = true)
        val cplus = Skill(name = "C++", type = SkillType.LANGUAGE.name, isActive = true)
        val rust = Skill(name = "Rust", type = SkillType.LANGUAGE.name, isActive = true)
        val net = Skill(name = ".NET", type = SkillType.FRAMEWORK.name, isActive = true)
        val axum = Skill(name = "Axum", type = SkillType.FRAMEWORK.name, isActive = true)
        val mssql = Skill(name = "MsSQL", type = SkillType.DATABASE.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
        val unity = Skill(name = "Unity", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(c, cplus, rust, net, axum, mssql, redis, unity))

        // project / project_detail / project_skill 초기화

        val project1 = Project(
                name = "Developing a high-performance gaming server",
                description = "Large-scale traffic online gaming server",
                startYear = 2018,
                startMonth = 6,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project1.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Develop large-scale traffic servers with C#, Rust", url = null, isActive = true),
                        ProjectDetail(content = "Real-time communication using WebSocket, UDP, etc", url = null, isActive = true)
                )
        )
        project1.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project1, skill = c),
                        ProjectSkill(project = project1, skill = rust),
                        ProjectSkill(project = project1, skill = mssql),
                        ProjectSkill(project = project1, skill = redis)
                )
        )
        val project2 = Project(
                name = "Elise Pang",
                description = "Rookiss Internet lecture",
                startYear = 2024,
                startMonth = 1,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project2.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Developing with Unity Engine", url = null, isActive = true),
                        ProjectDetail(content = "New feature update scheduled", url = null, isActive = true),
                        ProjectDetail(content = "Github Repository", url = "https://github.com/Raccoon26", isActive = true)
                )
        )
        project2.skills.addAll(
                mutableListOf(
                        ProjectSkill(project = project2, skill = c),
                        ProjectSkill(project = project2, skill = rust),
                        ProjectSkill(project = project2, skill = unity)
                )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))

        val account = Account(
            loginId = "admin1",
            pw = "\$2a\$10\$80bUwo3mnXcgary/NO6gOedwPYNC50S0T4ct/Yk.gktcH/imF6Ma."
        )
        accountRepository.save(account)
    }
}