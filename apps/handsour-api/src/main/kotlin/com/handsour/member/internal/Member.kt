package com.handsour.member.internal

import com.handsour.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
class Member(
    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val name: String,
) : BaseEntity()
