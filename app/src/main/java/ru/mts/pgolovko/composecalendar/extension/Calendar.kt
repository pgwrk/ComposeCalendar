package ru.mts.pgolovko.composecalendar.extension

import android.icu.util.Calendar
import java.text.SimpleDateFormat

fun Calendar.asString(): String {
    val format = SimpleDateFormat("MMMM yyyy")
    return format.format(time)
}

fun Calendar.asDayOfMonthString(): String {
    val format = SimpleDateFormat("dd MMMM")
    return format.format(time)
}

fun Calendar.getDayAsString(): String = get(Calendar.DATE).toString()