package com.security.jwt.api.domain

import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Column

@Entity
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: BigInteger,
    @Column(unique = true)
    val username: String,
    @Column(length = 100)
    val password: String,
    val enabled: Boolean,
    val name: String
)
