package com.security.jwt.api.service

import com.security.jwt.api.domain.Account
import com.security.jwt.api.domain.dto.LoginDTO

interface AccountService {

  /**
   * Finds an enable account by its username and password.
   *
   * @author Frank Edward Daza González.
   * @param loginDTO
   * @return Account? Return an Account if exist, otherwise return a null.
   */
  fun login(loginDTO: LoginDTO): Account?

}
