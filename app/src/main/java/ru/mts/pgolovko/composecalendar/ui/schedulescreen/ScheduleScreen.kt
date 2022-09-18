package ru.mts.pgolovko.composecalendar.ui.schedulescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun ScheduleScreen(onBack: ()->Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Schedule screen")
        Button(onClick = onBack) {
            Text(text = "Back")
        }
    }
}

@Preview
@Composable
private fun ScheduleScreenPreview() = AppTheme {
    ScheduleScreen { }
}