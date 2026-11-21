package com.handsour.member

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.test.ApplicationModuleTest
import org.springframework.modulith.test.PublishedEvents
import org.springframework.modulith.test.Scenario
import java.util.function.Supplier

@ApplicationModuleTest(extraIncludes = ["testcontainers"])
class MemberModuleTest(
    @Autowired private val memberService: MemberService,
) {
    @Test
    fun `회원가입하면 MemberRegistered 이벤트가 발행된다`(scenario: Scenario) {
        scenario.stimulate(Supplier { memberService.register("a@handsour.com", "손") })
            .andWaitForEventOfType(MemberRegistered::class.java)
            .toArriveAndVerify { event -> assertEquals("a@handsour.com", event.email) }
    }

    @Test
    fun `이미 가입된 이메일이면 예외가 나고 이벤트는 추가로 발행되지 않는다`(events: PublishedEvents) {
        memberService.register("dup@handsour.com", "손")

        assertThrows<IllegalArgumentException> { memberService.register("dup@handsour.com", "손") }
        assertEquals(1, events.ofType(MemberRegistered::class.java).matching { it.email == "dup@handsour.com" }.count())
    }
}
