package ru.mts.pgolovko.composecalendar.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

private enum class FontSize(val value: TextUnit) {
    Large(20.sp),
    Small(14.sp),
    VerySmall(12.sp)
}

@Stable
class DesignSystemTypography(
    val h3Medium: TextStyle,
    val h3Regular: TextStyle,
    val p3Medium: TextStyle,
    val p2Medium: TextStyle
)

val dsTypography =  DesignSystemTypography(
    h3Medium = TextStyle(
        //fontFamily = ...,
        fontWeight = FontWeight.Medium,
        fontSize = FontSize.Large.value,
    ),
    h3Regular = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = FontSize.Large.value,
    ),
    p3Medium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = FontSize.VerySmall.value,
    ),
    p2Medium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = FontSize.Small.value,
    )
)