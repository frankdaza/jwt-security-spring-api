package com.security.jwt.api.service

import com.security.jwt.api.domain.Account
import com.security.jwt.api.domain.AccountRole
import com.security.jwt.api.domain.dto.LoginDTO
import com.security.jwt.api.repository.AccountRepository
import com.security.jwt.api.repository.AccountRoleRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountRoleRepository: AccountRoleRepository
) : AccountService, AccountRoleService, UserDetailsService {

  @Transactional
  override fun login(loginDTO: LoginDTO): Account? {
    return accountRepository.findAccountByUsernameAndPasswordAndEnabled(loginDTO.username, loginDTO.password)
  }

  @Transactional(readOnly = true)
  override fun findAccountRolesByAccountUsername(username: String): List<AccountRole> {
    return accountRoleRepository.findAccountRolesByAccount_Username(username)
  }

  @Transactional(readOnly = true)
  override fun findAccountByUsername(username: String): Account? {
    return accountRepository.findAccountByUsername(username)
  }

  @Transactional(readOnly = true)
  override fun loadUserByUsername(username: String): UserDetails {
    val account: Account = accountRepository.findAccountByUsername(username)
        ?: throw UsernameNotFoundException("There is no username: $username in the system!")
    val accountRoles: List<AccountRole> = accountRoleRepository.findAccountRolesByAccount_Username(username)
    val authorities: List<GrantedAuthority> = accountRoles.map { SimpleGrantedAuthority(it.role.name) }
    return User(account.username, account.password, account.enabled, true, true, true, authorities)
  }
}
