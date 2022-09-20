package ru.mts.pgolovko.composecalendar.ui.common.calendar.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.mts.pgolovko.composecalendar.ui.common.calendar.toList
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun MonthContent(
    days: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),

        // content padding
        content = {
            items(days.size) { index ->
                val color = when  {
                    days[index] == selected -> AppTheme.colors.primary
                    (index + 1) % 7 == 0 || (index + 2) % 7 == 0 -> AppTheme.colors.textTertiary
                    else -> AppTheme.colors.textPrimary
                }

                Text(
                    text = days[index],
                    modifier = Modifier.clickable { onSelect(days[index]) },
                    textAlign = TextAlign.Center,
                    style = AppTheme.typography.h3Regular,
                    color = color
                )
            }
        }
    )
}

@Preview
@Composable
private fun MonthContentPreview() = AppTheme {
    val daysMatrix = arrayOf(
        arrayOf("", "", "", "1", "2", "3", "4"),
        arrayOf("5", "6", "7", "8", "9", "10", "11"),
        arrayOf("12", "13", "14", "15", "16", "17", "18"),
        arrayOf("19", "20", "21", "22", "23", "24", "25"),
        arrayOf("26", "27", "28", "29", "30", "", "")
    )

    MonthContent(days = daysMatrix.toList(), "21", {})
}