package ru.mts.pgolovko.composecalendar.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
class DesignSystemColors(
    val textHeadline: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val background: Color,
    val backgroundSecondary: Color,
    val icon: Color,
    val primary: Color,
    val grayscale0: Color
)

val dsLightColors =  DesignSystemColors(
    textHeadline = Color(0xFF000000),
    textPrimary = Color(0xFF1D2023),
    textSecondary = Color(0xFF626C77),
    textTertiary = Color(0xFF969FA8),
    background = Color(0xFFFFFFFF),
    backgroundSecondary = Color(0xFFF2F3F7),
    icon = Color(0xFF000000),
    primary = Color(0xFFE30611),
    grayscale0 = Color(0xFFFFFFFF)
)

val dsDarkColors =  DesignSystemColors(
    textHeadline = Color(0xFFFFFFFF),
    textPrimary = Color(0xFFFAFAFA),
    textSecondary = Color(0xFF969FA8),
    textTertiary = Color(0xFF626C77),
    background = Color(0xFF000000),
    backgroundSecondary = Color(0x40626C77),
    icon = Color(0xFFFFFFFF),
    primary = Color(0xFFE30611),
    grayscale0 = Color(0xFFFFFFFF)
)