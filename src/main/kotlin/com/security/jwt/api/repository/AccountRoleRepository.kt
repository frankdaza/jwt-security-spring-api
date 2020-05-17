package com.security.jwt.api.repository

import com.security.jwt.api.domain.AccountRole
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRoleRepository : JpaRepository<AccountRole, Long> {

  /**
   * Finds account roles by account username.
   *
   * @author Frank Edward Daza González.
   * @param username
   * @return List<AccountRole> Return a list of account roles.
   */
  fun findAccountRolesByAccount_Username(username: String): List<AccountRole>
}
