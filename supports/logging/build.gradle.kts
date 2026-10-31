dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // tracing (로그의 traceId/spanId)
    implementation("org.springframework.boot:spring-boot-micrometer-tracing-brave")
    // monitoring
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("io.micrometer:micrometer-tracing-bridge-brave")
    // Slack Appender
    implementation("com.github.maricn:logback-slack-appender:${project.properties["slackAppenderVersion"]}")
}
