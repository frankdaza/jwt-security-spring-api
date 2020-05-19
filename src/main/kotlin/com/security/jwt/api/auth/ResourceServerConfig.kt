package com.security.jwt.api.auth

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableResourceServer
class ResourceServerConfig : ResourceServerConfigurerAdapter() {
  @Throws(Exception::class)
  override fun configure(http: HttpSecurity) {
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/hi").permitAll()
        .anyRequest().authenticated()
        .and()
        .cors().configurationSource(corsConfigurationSource())
  }

  @Bean
  fun corsConfigurationSource(): CorsConfigurationSource {
    val configuration = CorsConfiguration()
    configuration.allowedOrigins = listOf("http://127.0.0.1:4200")
    configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
    configuration.allowCredentials = true
    configuration.allowedHeaders = listOf("Content-Type", "Authorization")
    val source = UrlBasedCorsConfigurationSource()
    source.registerCorsConfiguration("/**", configuration)
    return source
  }

  @Bean
  fun corsFilter(): FilterRegistrationBean<CorsFilter> {
    val filterRegistrationBean = FilterRegistrationBean(CorsFilter(corsConfigurationSource()))
    filterRegistrationBean.order = Ordered.HIGHEST_PRECEDENCE
    return filterRegistrationBean
  }
}
