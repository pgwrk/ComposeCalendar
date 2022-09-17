package ru.mts.pgolovko.composecalendar.ui.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.mts.pgolovko.composecalendar.ui.theme.ComposeCalendarTheme

@Composable
fun MainScreen(onShowSchedule: ()->Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Main screen")
        Button(onClick = onShowSchedule) {
            Text(text = "show schedule")
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() = ComposeCalendarTheme {
    MainScreen { }
}