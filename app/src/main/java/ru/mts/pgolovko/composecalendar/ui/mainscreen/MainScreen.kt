package ru.mts.pgolovko.composecalendar.ui.mainscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.mts.pgolovko.composecalendar.R
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun MainScreen(onShowSchedule: ()->Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "May 2021",
            style = AppTheme.typography.h3Medium,
            color = AppTheme.colors.textHeadline
        )
        Text(
            text = "Mon",
            style = AppTheme.typography.p3Medium,
            color = AppTheme.colors.textSecondary
        )
        Text(
            text = "01:00 Sleep",
            style = AppTheme.typography.h3Regular,
            color = AppTheme.colors.textPrimary
        )

        Button(
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