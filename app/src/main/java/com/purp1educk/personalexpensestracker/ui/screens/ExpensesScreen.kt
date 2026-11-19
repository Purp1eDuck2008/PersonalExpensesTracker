package com.purp1educk.personalexpensestracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purp1educk.personalexpensestracker.model.Expense
import com.purp1educk.personalexpensestracker.model.ExpenseCategory
import com.purp1educk.personalexpensestracker.ui.components.ExpenseItem

@Composable
fun ExpensesScreen(
    expenses: List<Expense>,
    onDelete: (Expense) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn() {
            items(items = expenses, key = {it.id}) { expense ->
                ExpenseItem(expense, { onDelete(expense) })
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun ExpensesScreenPreview() {
    ExpensesScreen(
        expenses = listOf(
            Expense(1, "Продукты", 1240.50, ExpenseCategory.FOOD),
            Expense(2, "Такси", 415.0, ExpenseCategory.TAXI)
        ),
        onDelete = {}
    )
}