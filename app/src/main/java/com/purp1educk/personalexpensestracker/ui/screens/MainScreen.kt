package com.purp1educk.personalexpensestracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.purp1educk.personalexpensestracker.ui.components.AddExpenseDialog
import com.purp1educk.personalexpensestracker.ui.components.BottomNavigationBar
import com.purp1educk.personalexpensestracker.ui.components.Header
import com.purp1educk.personalexpensestracker.ui.components.bottomNavigationItems
import com.purp1educk.personalexpensestracker.ui.navigation.AppNavigation
import com.purp1educk.personalexpensestracker.viewmodel.ExpenseViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val viewModel: ExpenseViewModel = viewModel()
    val currentDestination = backStackEntry?.destination

    var showDialog by rememberSaveable() { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItems,
                isSelected = { item -> currentDestination?.hasRoute(item.route::class) == true },
                onTabClick = { item ->
                    navController.navigate(item.route) { launchSingleTop = true }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Добавить расход"
                )
            }
        },
        topBar = {
            Header(totalAmount = viewModel.getTotalAmount())
        }
    ) { innerPadding ->

        if (showDialog) {
            AddExpenseDialog(
                onDismiss = { showDialog = false },
                onConfirm = { title, amount, category ->
                     viewModel.addExpense(title, amount, category)
                    showDialog = false
                }
            )
        }
        AppNavigation(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}