package com.silmaapps.barberfyschedule.framework.controllers

import com.silmaapps.barberfyschedule.app.domain.exceptions.BarberDateExistException
import com.silmaapps.barberfyschedule.app.services.Dtos.BarberDateDto
import com.silmaapps.barberfyschedule.app.services.ScheduleService
import com.silmaapps.barberfyschedule.framework.requests.AddBarberDateRequest
import org.springframework.expression.common.ExpressionUtils.toInt
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@RestController
class ScheduleController @Inject constructor(val scheduleService: ScheduleService){


    @PostMapping("/schedule")
    fun schedule(@RequestBody addBarberDateRequest: AddBarberDateRequest) : ResponseEntity<*>{
        val dateTime = LocalDateTime.parse(addBarberDateRequest.datetime)
        val barberDate = BarberDateDto(dateTime, addBarberDateRequest.userId.toInt())

        try{
            scheduleService.addDateToSchedule(barberDate)
        } catch (exception: BarberDateExistException){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.message)
        }


        return ResponseEntity.ok("Date added! The number of dates is ${scheduleService.getNumberOfDates()}")

    }

    @GetMapping("/schedule")
    fun getDatesInSchedule() : List<*> {
        return scheduleService.getBarberDates()
    }
}