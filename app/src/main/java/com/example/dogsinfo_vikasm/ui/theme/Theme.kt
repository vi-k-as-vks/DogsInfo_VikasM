package com.example.dogsinfo_vikasm.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(

    primary = md_light_primary,
    onPrimary = md_light_onPrimary,
    primaryContainer = md_light_primaryContainer,
    onPrimaryContainer = md_light_onPrimaryContainer,

    secondary = md_light_secondary,
    onSecondary = md_light_onSecondary,
    secondaryContainer = md_light_secondaryContainer,
    onSecondaryContainer = md_light_onSecondaryContainer,

    tertiary = md_light_tertiary,
    onTertiary = md_light_onTertiary,

    background = md_light_background,
    surface = md_light_surface,

    error = md_light_error
)

private val DarkColors = darkColorScheme(

    primary = md_dark_primary,
    onPrimary = md_dark_onPrimary,
    primaryContainer = md_dark_primaryContainer,
    onPrimaryContainer = md_dark_onPrimaryContainer,

    secondary = md_dark_secondary,
    onSecondary = md_dark_onSecondary,
    secondaryContainer = md_dark_secondaryContainer,

    tertiary = md_dark_tertiary,
    onTertiary = md_dark_onTertiary,

    background = md_dark_background,
    surface = md_dark_surface,

    error = md_dark_error
)

@Composable
fun DogsInfoTheme(

    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit

) {

    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )

}