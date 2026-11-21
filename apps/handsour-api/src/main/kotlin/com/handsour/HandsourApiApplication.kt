package com.handsour

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.modulith.Modulithic
import org.springframework.scheduling.annotation.EnableAsync
import java.util.TimeZone

@ConfigurationPropertiesScan
@SpringBootApplication
@EnableAsync
@Modulithic(sharedModules = ["config"])
class HandsourApiApplication {

    @PostConstruct
    fun started() {
        // set timezone
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    }
}

fun main(args: Array<String>) {
    runApplication<HandsourApiApplication>(*args)
}
