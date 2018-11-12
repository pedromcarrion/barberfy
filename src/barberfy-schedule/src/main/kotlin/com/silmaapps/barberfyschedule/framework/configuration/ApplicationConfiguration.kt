package com.silmaapps.barberfyschedule.framework.configuration

import com.silmaapps.barberfyschedule.app.domain.repositories.BarberScheduleRepository
import com.silmaapps.barberfyschedule.app.services.ScheduleService
import com.silmaapps.barberfyschedule.framework.repositories.JdbcBarberScheduleRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun scheduleService(barberScheduleRepository: BarberScheduleRepository) : ScheduleService{
        return ScheduleService(barberScheduleRepository)
    }
}