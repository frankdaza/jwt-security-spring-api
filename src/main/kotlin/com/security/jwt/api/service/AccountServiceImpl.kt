package com.security.jwt.api.service

import com.security.jwt.api.domain.Account
import com.security.jwt.api.domain.AccountRole
import com.security.jwt.api.domain.dto.LoginDTO
import com.security.jwt.api.repository.AccountRepository
import com.security.jwt.api.repository.AccountRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountRoleRepository: AccountRoleRepository
) : AccountService, AccountRoleService {

  @Transactional
  override fun login(loginDTO: LoginDTO): Account? {
    return accountRepository.findAccountByUsernameAndPasswordAndEnabled(loginDTO.username, loginDTO.password)
  }

  @Transactional(readOnly = true)
  override fun findAccountRolesByAccountUsername(username: String): List<AccountRole> {
    return accountRoleRepository.findAccountRolesByAccount_Username(username)
  }
}
