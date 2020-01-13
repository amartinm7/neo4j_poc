package com.amm.neo4jpoc.infrastructure.framework.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .authorizeRequests()
            .antMatchers("/actuator/**").permitAll()
            .and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
    }
}
