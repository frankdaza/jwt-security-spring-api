package com.security.jwt.api.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.OneToMany

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(unique = true)
    val username: String,
    @Column(length = 60)
    val password: String,
    val enabled: Boolean,
    val name: String,
    @OneToMany
    val accountRole: List<AccountRole>
)
