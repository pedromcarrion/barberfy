package com.silmaapps.barberfyschedule.app.domain

import com.silmaapps.barberfyschedule.app.domain.exceptions.BarberDateExistException
import java.time.LocalDateTime

class Schedule () {

    private val dates : HashMap<LocalDateTime, BarberDate> = HashMap()

    private val years : List<BarberYear> = ArrayList()


    fun addDate(barberDate: BarberDate){

        val numberMonth = barberDate.date.monthValue
        val numberYear = barberDate.date.year
        val numberDay = barberDate.date.dayOfMonth

        val day = years[numberYear].months[numberMonth].days[numberDay]

        if (dates.containsKey(barberDate.date)){
            throw BarberDateExistException("Ya hay una cita en esa fecha ${barberDate.date}")

        }

        dates[barberDate.date] = barberDate
    }

    fun getNumberOfDates() : Int {
        return dates.size
    }

    fun getBarberDates(): ArrayList<BarberDate> {
        return ArrayList(dates.values)
    }
}