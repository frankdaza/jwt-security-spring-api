package com.security.jwt.api.domain

import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column

@Entity
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: BigInteger,
    @Column(unique = true)
    val name: String
)
