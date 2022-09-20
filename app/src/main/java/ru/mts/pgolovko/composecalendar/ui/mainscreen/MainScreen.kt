package ru.mts.pgolovko.composecalendar.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mts.pgolovko.composecalendar.R
import ru.mts.pgolovko.composecalendar.ui.common.calendar.DsCalendar
import ru.mts.pgolovko.composecalendar.ui.common.calendar.rememberDsCalendarInternalState
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun MainScreen(onShowSchedule: ()->Unit) {
    val calendarState = rememberDsCalendarInternalState()

    Column(
        modifier = Modifier
            .background(color = AppTheme.colors.background)
            .fillMaxWidth()
    ) {
        DsCalendar(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
            state = calendarState
        )

        Spacer(modifier = Modifier.height(26.dp))

        Button(
            modifier = Modifier
                .height(42.dp)
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.primary),
            shape = AppTheme.shapes.medium,
            onClick = onShowSchedule
        ) {
            Text(
                text = stringResource(id = R.string.show_schedule),
                style = AppTheme.typography.p2Medium,
                color = AppTheme.colors.grayscale0
            )
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() = AppTheme {
    MainScreen { }
}