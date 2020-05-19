package com.security.jwt.api.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class BCryptPasswordTest {

  @Autowired
  private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

  @Test
  fun generateBCryptPassword() {
    val password = "123456"
    println(bCryptPasswordEncoder.encode(password))
  }

}
