package ru.mts.pgolovko.composecalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.mts.pgolovko.composecalendar.ui.mainscreen.MainScreen
import ru.mts.pgolovko.composecalendar.ui.schedulescreen.ScheduleScreen
import ru.mts.pgolovko.composecalendar.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Destinations.Main
                ) {
                    composable(Destinations.Main) {
                        MainScreen { navController.navigate(Destinations.Schedule) }
                    }

                    composable(Destinations.Schedule) {
                        ScheduleScreen { navController.popBackStack() }
                    }
                }
            }
        }
    }
}

object Destinations {
    const val Main = "main"
    const val Schedule = "schedule"
}