package com.security.jwt.api.service

import com.security.jwt.api.domain.Account
import com.security.jwt.api.domain.AccountRole
import com.security.jwt.api.domain.dto.LoginDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class AccountServiceTest {

  @Autowired
  private lateinit var accountService: AccountService

  @Autowired
  private lateinit var accountRoleService: AccountRoleService

  companion object {
    private const val username = "MYADMIN"
    private val loginDto = LoginDTO(username, "123456")
  }

  @Test
  fun `Should login a user`() {
    val account: Account? = accountService.login(loginDto)
    Assertions.assertNotNull(account)
  }

  @Test
  fun `Should get all user's roles given an username`() {
    val accountRoles: List<AccountRole> = accountRoleService.findAccountRolesByAccountUsername(username)
    Assertions.assertNotNull(accountRoles)
  }
}
