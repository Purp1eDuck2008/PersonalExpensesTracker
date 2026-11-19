package com.purp1educk.personalexpensestracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.purp1educk.personalexpensestracker.ui.screens.ExpensesScreen
import com.purp1educk.personalexpensestracker.ui.screens.StatisticsScreen
import com.purp1educk.personalexpensestracker.viewmodel.ExpenseViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    viewModel: ExpenseViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ExpensesRoute,
        modifier = modifier
    ) {
        composable<ExpensesRoute> {
            ExpensesScreen(
                expenses = viewModel.expenses,
                onDelete = viewModel::deleteExpense
            )
        }
        composable<StatisticsRoute> {
            StatisticsScreen(
                amountByCategory = viewModel.getAmountByCategory()
            )
        }
    }
}