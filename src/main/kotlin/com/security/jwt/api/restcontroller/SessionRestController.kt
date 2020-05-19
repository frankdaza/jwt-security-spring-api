package com.security.jwt.api.restcontroller

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionRestController {

  companion object {
    private const val name = "Knarf"
  }

  @GetMapping("/hi")
  fun hi(): String {
    return "Hi $name!"
  }

  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
  @GetMapping("/user")
  fun user(): String {
    return "HI $name USER!"
  }

  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_REPORTS')")
  @GetMapping("/reports")
  fun reports(): String {
    return "HI $name REPORTS!"
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @GetMapping("/admin")
  fun admin(): String {
    return "HI $name ADMIN!"
  }
}
