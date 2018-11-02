package com.silmaapps.barberfyschedule.app.services

import com.silmaapps.barberfyschedule.app.domain.BarberDate
import com.silmaapps.barberfyschedule.app.domain.Schedule
import com.silmaapps.barberfyschedule.app.services.Dtos.BarberDateDto
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class ScheduleService {

    private var schedule = Schedule()

    fun addDateToSchedule(barberDateDto: BarberDateDto){
        var date = LocalDateTime.now()
        var user = 1;
        var barberDate = BarberDate(barberDateDto.date, barberDateDto.userId)


        schedule.addDate(barberDate);




    }

    fun getNumberOfDates() : Int{
        return schedule.getNumberOfDates();
    }

    fun getBarberDates(): List<BarberDateDto> {
        val barberDates = schedule.getBarberDates()

        return barberDates.map { barberDate -> BarberDateDto(barberDate.date, barberDate.userId) }
    }
}