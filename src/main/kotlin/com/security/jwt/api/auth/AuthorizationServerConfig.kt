package com.security.jwt.api.auth

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter

@Configuration
@EnableAuthorizationServer
class AuthorizationServerConfig(
    private val passwordEncoder: BCryptPasswordEncoder,
    @Qualifier("authenticationManager") private val authenticationManager: AuthenticationManager,
    private val additionalTokenInformation: AdditionalTokenInformation
) : AuthorizationServerConfigurerAdapter() {

  companion object {
    private const val validityMilliseconds = 3600
  }

  @Throws(Exception::class)
  override fun configure(security: AuthorizationServerSecurityConfigurer) {
    security.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
  }

  @Throws(Exception::class)
  override fun configure(clients: ClientDetailsServiceConfigurer) {
    clients.inMemory().withClient("clientapp")
        .secret(passwordEncoder.encode("123456"))
        .scopes("read", "write")
        .authorizedGrantTypes("password", "refresh_token")
        .accessTokenValiditySeconds(validityMilliseconds)
        .refreshTokenValiditySeconds(validityMilliseconds)
  }

  @Bean
  fun accessTokenConverter(): JwtAccessTokenConverter {
    val jwtAccessTokenConverter = JwtAccessTokenConverter()
    jwtAccessTokenConverter.setSigningKey(JwtConfig.PRIVATE_KEY)
    jwtAccessTokenConverter.setVerifierKey(JwtConfig.PUBLIC_KEY)
    return jwtAccessTokenConverter
  }

  @Throws(Exception::class)
  override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
    val tokenEnhancerChain = TokenEnhancerChain()
    tokenEnhancerChain.setTokenEnhancers(listOf(additionalTokenInformation, accessTokenConverter()))
    endpoints.authenticationManager(authenticationManager)
        .accessTokenConverter(accessTokenConverter())
        .tokenEnhancer(tokenEnhancerChain)
  }
}
