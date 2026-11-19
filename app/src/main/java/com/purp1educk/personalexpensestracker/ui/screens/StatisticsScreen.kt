package com.purp1educk.personalexpensestracker.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.purp1educk.personalexpensestracker.model.ExpenseCategory
import com.purp1educk.personalexpensestracker.ui.components.ExpenseCategoryItem

@Composable
fun StatisticsScreen(
    amountByCategory: Map<ExpenseCategory, Double>
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(items = amountByCategory.toList(), key = { it.first }) { (category, amount) ->
            ExpenseCategoryItem(
                category = category,
                amount = amount,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatisticsScreenPreview() {
    StatisticsScreen(
        amountByCategory = mapOf(
            ExpenseCategory.FOOD to 500.0,
            ExpenseCategory.TAXI to 300.1,
            ExpenseCategory.ENTERTAINMENTS to 200.0
        )
    )
}