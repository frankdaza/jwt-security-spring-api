package com.security.jwt.api.service

import com.security.jwt.api.domain.AccountRole

interface AccountRoleService {

  /**
   * Finds account roles by account username.
   *
   * @author Frank Edward Daza González.
   * @param username
   * @return List<AccountRole> Return a list of account roles.
   */
  fun findAccountRolesByAccountUsername(username: String): List<AccountRole>

}
