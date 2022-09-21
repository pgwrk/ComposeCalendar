package ru.mts.pgolovko.composecalendar.ui.common.calendar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.mts.pgolovko.composecalendar.R
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

@Composable
fun CalendarHeader(
    date: String,
    onPrevMonth: () -> Unit,
    onNextMonth: () -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = date,
                modifier = Modifier
                    .padding(start = 12.dp),
                style = AppTheme.typography.h3Medium,
                color = AppTheme.colors.textHeadline
            )

            Spacer(modifier = Modifier.width(4.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_drop_up),
                    tint = AppTheme.colors.icon,
                    contentDescription = ""
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_drop_down),
                    tint = AppTheme.colors.icon,
                    contentDescription = ""
                )
            }
        }

        Row {
            IconButton(
                modifier = Modifier
                    .background(color = AppTheme.colors.backgroundSecondary, shape = CircleShape)
                    .then(Modifier.size(32.dp)),
                onClick = { onPrevMonth() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_left),
                    tint = AppTheme.colors.icon,
                    contentDescription = ""
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                modifier = Modifier
                    .background(color = AppTheme.colors.backgroundSecondary, shape = CircleShape)
                    .then(Modifier.size(32.dp)),
                onClick = { onNextMonth() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    tint = AppTheme.colors.icon,
                    contentDescription = ""
                )
            }
        }
    }
}