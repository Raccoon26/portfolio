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

        println("스프링 실행, 데이터 초기화")

        val achievements = mutableListOf<Achievement>(
                Achievement(
                        title = "2021 해킹대회 우수상",
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
                Introduction(content = "주도적으로 문제를 찾고, 해결하는 개발자입니다.", isActive = true),
                Introduction(content = "기술을 위한 기술이 아닌, 사람의 흥미를 끄는 기술을 추구합니다.", isActive = true),
                Introduction(content = "기존 소스를 리팩토링하여 더 좋은 구조로 개선하는 작업을 좋아합니다.", isActive = true),
                Introduction(content = "33raccoon33@gmail.com", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
                Link(name = "Github", content = "https://github.com/Raccoon26", isActive = true),
                Link(name = "Linkedin", content = "https://www.linkedin.com/in/chanhyeok-shin-85640621b/", isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
                title = "원광대학교(Wonkwang Univ.)",
                description = "컴퓨터과학 전공",
                startYear = 2018,
                startMonth = 2,
                endYear = 2024,
                endMonth = 2,
                isActive = true
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "멋쟁이 사자처럼 운영진", isActive = true),
                        ExperienceDetail(content = "소프트웨어 연구 학회 활동", isActive = true)
                )
        )
        val experience2 = Experience(
                title = "Paper Village",
                description = "유니티 게임 서버 개발자",
                startYear = 2015,
                startMonth = 9,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        experience2.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "C#, RUST 기반 게임 서버 개발", isActive = true),
                        ExperienceDetail(content = "Entity Framework Core 개발", isActive = true)
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
                name = "고성능 게임 서버 개발",
                description = "대규모 온라인 게임 고성능 서버 개발",
                startYear = 2018,
                startMonth = 6,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project1.addDetails(
                mutableListOf(
                        ProjectDetail(content = "C#, Rust를 활용하여 대규모 트래픽 서버 개발", url = null, isActive = true),
                        ProjectDetail(content = "WebSocket, UDP등을 활용한 실시간 통신", url = null, isActive = true)
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
                name = "엘리스 팡",
                description = "Rookiss님 게임 모작",
                startYear = 2024,
                startMonth = 1,
                endYear = null,
                endMonth = null,
                isActive = true
        )
        project2.addDetails(
                mutableListOf(
                        ProjectDetail(content = "Unity 엔진을 활용하여 개발", url = null, isActive = true),
                        ProjectDetail(content = "신규 기능 추가 예정", url = null, isActive = true),
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