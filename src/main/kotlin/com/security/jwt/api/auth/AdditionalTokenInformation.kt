package com.security.jwt.api.auth

import com.security.jwt.api.domain.Account
import com.security.jwt.api.service.AccountService
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.TokenEnhancer
import org.springframework.stereotype.Component

@Component
class AdditionalTokenInformation(
    private val accountService: AccountService
) : TokenEnhancer {

  override fun enhance(accessToken: OAuth2AccessToken, authentication: OAuth2Authentication): OAuth2AccessToken {
    val account: Account? = accountService.findAccountByUsername(authentication.name)
    val info: MutableMap<String, Any> = HashMap()

    if (account != null) {
      info["username"] = account.username
      info["name"] = account.name
    }

    (accessToken as DefaultOAuth2AccessToken).additionalInformation = info
    return accessToken
  }
}
