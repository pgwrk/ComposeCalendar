package ru.mts.pgolovko.composecalendar.ui.common.calendar.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.mts.pgolovko.composecalendar.R
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun DaysOfWeekLine() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        DAYS.forEach {
            DayOfWeek(it)
        }
    }
}

@Composable
private fun DayOfWeek(@StringRes strId: Int) {
    Text(
        text = stringResource(id = strId),
        style = AppTheme.typography.p3Medium,
        color = AppTheme.colors.textSecondary
    )
}

private val DAYS = listOf(
    R.string.monday,
    R.string.tuesday,
    R.string.wednesday,
    R.string.thursday,
    R.string.friday,
    R.string.saturday,
    R.string.sunday,
)

@Preview
@Composable
private fun DaysOfWeekLinePreview() = AppTheme {
    DaysOfWeekLine()
}