package com.handsour.notification

import com.handsour.member.MemberRegistered
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.events.CompletedEventPublications
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.Scenario

@ApplicationModuleTest(extraIncludes = ["testcontainers"])
class NotificationModuleTest(
    @Autowired private val completedPublications: CompletedEventPublications,
) {
    @Test
    fun `MemberRegistered를 받으면 이벤트 발행 기록이 완료 처리된다`(scenario: Scenario) {
        val event = MemberRegistered(1L, "b@handsour.com", "손")

        scenario.publish(event)
            .andWaitForStateChange { completedPublications.findAll().any { it.event == event } }
            .andVerify { done -> assertTrue(done) }
    }

    @Test
    fun `직렬화한 이벤트가 255자를 넘어도 발행 기록이 완료 처리된다`(scenario: Scenario) {
        val event = MemberRegistered(2L, "long@handsour.com", "a".repeat(230))

        scenario.publish(event)
            .andWaitForStateChange { completedPublications.findAll().any { it.event == event } }
            .andVerify { done -> assertTrue(done) }
    }
}
