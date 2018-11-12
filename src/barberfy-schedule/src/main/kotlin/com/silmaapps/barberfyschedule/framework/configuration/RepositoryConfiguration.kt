package com.silmaapps.barberfyschedule.framework.configuration

import com.silmaapps.barberfyschedule.app.domain.repositories.BarberScheduleRepository
import com.silmaapps.barberfyschedule.framework.repositories.JdbcBarberScheduleRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
class RepositoryConfiguration {

    @Bean
    fun namedParameterJdbcTemplate(dataSource: DataSource) : NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }


    @Bean
    fun barberScheduleRepository(namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : BarberScheduleRepository{
        return JdbcBarberScheduleRepository(namedParameterJdbcTemplate);
    }


}