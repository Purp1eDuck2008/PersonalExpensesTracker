package com.purp1educk.personalexpensestracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.purp1educk.personalexpensestracker.ui.screens.MainScreen
import com.purp1educk.personalexpensestracker.ui.theme.PersonalExpensesTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersonalExpensesTrackerTheme {
                MainScreen()
            }
        }
    }
}