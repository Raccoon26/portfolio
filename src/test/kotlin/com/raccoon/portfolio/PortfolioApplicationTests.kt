package com.raccoon.portfolio

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class PortfolioApplicationTests {

	@Test
	fun contextLoads() {
	}
	@Test
	fun test(){
		val encrypted = BCryptPasswordEncoder().encode("mewhan")
		println(encrypted)
	}
}
