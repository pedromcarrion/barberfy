package com.silmaapps.barberfyschedule.framework.repositories

import com.silmaapps.barberfyschedule.app.domain.repositories.BarberScheduleRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class JdbcBarberScheduleRepository(val jdbcTemplate: NamedParameterJdbcTemplate) : BarberScheduleRepository {



    override fun getBarberSchedule() {
        //jdbcTemplate.query("", null, null)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}