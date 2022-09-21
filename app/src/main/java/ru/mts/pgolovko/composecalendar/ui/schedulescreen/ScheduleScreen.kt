package ru.mts.pgolovko.composecalendar.ui.schedulescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mts.pgolovko.composecalendar.R
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun ScheduleScreen(day: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val state = remember { SCHEDULE_ITEMS }

        Text(
            text = stringResource(id = R.string.schedule_header),
            style = AppTheme.typography.h3Medium,
            color = AppTheme.colors.textHeadline
        )

        Spacer(modifier = Modifier.size(8.dp))

        LazyColumn() {
            items(state) {
                ScheduleItem(title = it)
            }
        }
    }
}

@Composable
private fun ScheduleItem(title: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp)
    ) {
        Box(modifier = Modifier
            .align(Alignment.CenterVertically)
            .size(8.dp)
            .clip(CircleShape)
            .background(AppTheme.colors.primary)
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = title,
            style = AppTheme.typography.h3Regular,
            color = AppTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
private fun ScheduleScreenPreview() = AppTheme {
    ScheduleScreen("15th of September")
}

private val SCHEDULE_ITEMS = listOf(
    "00:00 Sleep", "01:00 Sleep","02:00 Sleep", "03:00 Sleep","04:00 Sleep", "05:00 Sleep","06:00 Sleep", "07:00 Sleep",
    "08:00 Wakeup", "09:00 Gymnastics","10:00 Breakfast", "11:00 Work","12:00 Work", "13:00 Work","14:00 Sleep", "15:00 Work",
    "16:00 Lunch", "17:00 Work","18:00 Work", "19:00 Work","20:00 Work", "21:00 Walking","22:00 Free time", "23:00 Dinner",
    "24:00 Gaming"
)
