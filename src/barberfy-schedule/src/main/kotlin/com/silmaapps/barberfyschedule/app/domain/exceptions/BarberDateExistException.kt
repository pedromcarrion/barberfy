package com.silmaapps.barberfyschedule.app.domain.exceptions

import java.lang.Exception

class BarberDateExistException : Exception{
    constructor(msg: String) : super(msg)
}