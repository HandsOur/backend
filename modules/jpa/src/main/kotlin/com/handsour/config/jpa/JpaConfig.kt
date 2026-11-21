package com.handsour.config.jpa

import org.springframework.boot.persistence.autoconfigure.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.handsour", "org.springframework.modulith.events.jpa"])
@EnableJpaRepositories(basePackages = ["com.handsour"])
class JpaConfig
