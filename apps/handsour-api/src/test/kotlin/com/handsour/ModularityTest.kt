package com.handsour

import com.tngtech.archunit.core.importer.ImportOption
import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter

class ModularityTest {
    private val modules = ApplicationModules.of(HandsourApiApplication::class.java)

    @Test
    fun printModules() {
        modules.forEach { println(it) }
    }

    @Test
    fun verifyModularity() {
        modules.verify()
    }

    @Test
    fun writeDocumentation() {
        Documenter(modules).writeDocumentation()
    }

    @Test
    fun `운영 클래스만으로 모듈을 만들어도 sharedModules가 모두 존재한다`() {
        val productionOnly = ImportOption { location ->
            !location.contains("/test/") && !location.contains("testFixtures") && !location.contains("test-fixtures")
        }

        ApplicationModules.of(HandsourApiApplication::class.java, productionOnly).sharedModules
    }
}
