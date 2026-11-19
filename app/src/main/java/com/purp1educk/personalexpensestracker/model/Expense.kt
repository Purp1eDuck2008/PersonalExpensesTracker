package com.purp1educk.personalexpensestracker.model

enum class ExpenseCategory (
    val title: String
) {
    FOOD("Еда"),
    TRANSFERS("Денежные переводы"),
    TAXI("Такси"),
    ENTERTAINMENTS("Развлечения"),
    HEALTH("Здоровье"),
    TRANSPORT("Транспорт"),
    OTHER("Другое")
}

data class Expense(
    val id: Int,
    val title: String,
    val amount: Double,
    val category: ExpenseCategory
)
