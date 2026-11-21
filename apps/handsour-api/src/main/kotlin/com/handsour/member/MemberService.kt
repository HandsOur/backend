package com.handsour.member

import com.handsour.member.internal.Member
import com.handsour.member.internal.MemberRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val eventPublisher: ApplicationEventPublisher,
) {
    @Transactional
    fun register(email: String, name: String): Long {
        require(!memberRepository.existsByEmail(email)) { "이미 가입된 이메일입니다: $email" }

        val member = memberRepository.save(Member(email = email, name = name))
        eventPublisher.publishEvent(MemberRegistered(member.id, member.email, member.name))
        return member.id
    }
}
