package com.security.jwt.api.repository

import com.security.jwt.api.domain.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigInteger

interface AccountRepository : JpaRepository<Account, Long> {

  /**
   * Finds an enable account by its username and password.
   *
   * @author Frank Edward Daza González.
   * @param loginDTO
   * @return Account? Return an Account if exist, otherwise return a null.
   */
  fun findAccountByUsernameAndPasswordAndEnabled(username: String, password: String, enabled: Boolean = true): Account?

}
