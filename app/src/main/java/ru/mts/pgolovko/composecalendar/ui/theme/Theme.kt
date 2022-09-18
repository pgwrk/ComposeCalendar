package ru.mts.pgolovko.composecalendar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        dsDarkColors
    } else {
        dsLightColors
    }

    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides dsTypography,
        LocalAppShape provides dsShapes,
        content = content
    )
}

val LocalAppColors = staticCompositionLocalOf<DesignSystemColors> {
    error("No colors provided")
}
val LocalAppTypography = staticCompositionLocalOf<DesignSystemTypography> {
    error("No typography provided")
}

val LocalAppShape = staticCompositionLocalOf<Shapes> {
    error("No shapes provided")
}

object AppTheme {
    val colors: DesignSystemColors
        @Composable
        get() = LocalAppColors.current

    val typography: DesignSystemTypography
        @Composable
        get() = LocalAppTypography.current

    val shapes: Shapes
        @Composable
        get() = LocalAppShape.current
}