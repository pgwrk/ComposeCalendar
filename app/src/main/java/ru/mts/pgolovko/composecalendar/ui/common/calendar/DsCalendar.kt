package ru.mts.pgolovko.composecalendar.ui.common.calendar

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mts.pgolovko.composecalendar.extension.asString
import ru.mts.pgolovko.composecalendar.extension.getDayAsString
import ru.mts.pgolovko.composecalendar.ui.common.calendar.view.CalendarHeader
import ru.mts.pgolovko.composecalendar.ui.common.calendar.view.DaysOfWeekLine
import ru.mts.pgolovko.composecalendar.ui.common.calendar.view.MonthContent
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun rememberDsCalendarInternalState(date: Calendar = Calendar.getInstance()): DsCalendarState = remember(date) {
    DsCalendarState(date)
}

@Composable
fun DsCalendar(
    modifier: Modifier = Modifier,
    state: DsCalendarState = rememberDsCalendarInternalState()
) {
    val internalState = remember { mutableStateOf(DsCalendarInternalState(state)) }

    Column(modifier = modifier.fillMaxWidth()) {
        CalendarHeader(
            state.date.asString(),
            onPrevMonth = {
                val newState = internalState.value.changeMonth(-1)
                internalState.value = newState
            },
            onNextMonth = {
                val newState = internalState.value.changeMonth(1)
                internalState.value = newState
            }
        )
        Spacer(modifier = Modifier.height(12.dp))

        DaysOfWeekLine()
        Spacer(modifier = Modifier.height(12.dp))

        MonthContent(
            days = internalState.value.daysMatrix.toList(),
            selected = internalState.value.state.date.getDayAsString()
        ) { selectedDay ->
            val newState = internalState.value.changeSelectedDate(selectedDay)
            internalState.value = newState
        }
    }
}

private class DsCalendarInternalState(
    val state: DsCalendarState,
    val daysMatrix: DaysMatrix = DaysMatrixCalculator.getMatrix(state.date)
) {
    fun changeSelectedDate(newDay: String): DsCalendarInternalState {
        val day = newDay.toInt()
        state.date.set(Calendar.DATE, day)

        return DsCalendarInternalState(state, daysMatrix)
    }

    fun changeMonth(delta: Int): DsCalendarInternalState {
        state.date.add(Calendar.MONTH, delta)

        return DsCalendarInternalState(state)
    }
}

@Preview
@Composable
private fun DsCalendarPreview() = AppTheme {
    DsCalendar()
}