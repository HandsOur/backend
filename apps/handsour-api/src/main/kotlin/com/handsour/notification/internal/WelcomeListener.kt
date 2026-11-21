package com.handsour.notification.internal

import com.handsour.member.MemberRegistered
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class WelcomeListener {
    private val log = LoggerFactory.getLogger(javaClass)

    @ApplicationModuleListener
    fun on(event: MemberRegistered) {
        log.info("[notification] 환영합니다, {}님 (memberId={})", event.name, event.memberId)
    }
}
