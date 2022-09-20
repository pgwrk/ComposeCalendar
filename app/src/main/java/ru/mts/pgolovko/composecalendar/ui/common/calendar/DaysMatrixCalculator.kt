package ru.mts.pgolovko.composecalendar.ui.common.calendar

import android.icu.util.Calendar

typealias DaysMatrix = Array<Array<String>>
fun DaysMatrix.toList(): List<String> {
    val res = mutableListOf<String>()
    forEach { days ->
        res.addAll(days.toList())
    }

    return res
}

object DaysMatrixCalculator {

    fun getMatrix(yearMonth: Calendar): DaysMatrix {
        val daysInMonth = yearMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH)
        val year = yearMonth.get(Calendar.YEAR)
        val month = yearMonth.get(Calendar.MONTH)

        val firstYearWeekInMonth = getWeekInYear(year, month, 1)
        val lastYearWeekInMonth = getWeekInYear(year, month, daysInMonth)

        val weeksInMonth = lastYearWeekInMonth - firstYearWeekInMonth + 1
        val days: DaysMatrix = Array(weeksInMonth) { Array(DAYS_IN_WEEK) { "" } }

        val curDay = getCalendar(year, month)
        repeat(daysInMonth) {
            curDay.set(Calendar.DATE, it + 1)

            val curYearWeekInMonth = getWeekInYear(year, month, it + 1)
            val weekNumber = curYearWeekInMonth - firstYearWeekInMonth
            val dayOwWeek = curDay.get(Calendar.DAY_OF_WEEK).dayNumber()

            days[weekNumber][dayOwWeek] = "${it + 1}"
        }

        return days
    }

    private fun getWeekInYear(year: Int, month: Int, day: Int): Int {
        val realWeekNumber = getCalendar(year, month, day).get(Calendar.WEEK_OF_YEAR)
        return if (realWeekNumber == MAX_WEEK_IN_YEAR && month == Calendar.JANUARY) 0 else realWeekNumber
    }


    private fun getCalendar(year: Int, month: Int): Calendar = Calendar.getInstance().apply {
        set(Calendar.YEAR, year)
        set(Calendar.MONTH, month)
    }

    private fun getCalendar(year: Int, month: Int, day: Int): Calendar = Calendar.getInstance().apply {
        set(year, month, day)
    }
}

private fun Int.dayNumber(): Int = when (this) {
    Calendar.MONDAY -> 0
    Calendar.SUNDAY -> 6
    else -> this - 2
}


private const val DAYS_IN_WEEK = 7
private const val MAX_WEEK_IN_YEAR = 52