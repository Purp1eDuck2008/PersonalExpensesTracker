package com.purp1educk.personalexpensestracker.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.purp1educk.personalexpensestracker.model.Expense
import com.purp1educk.personalexpensestracker.model.ExpenseCategory

class ExpenseViewModel : ViewModel() {
    private val _expenses = mutableStateListOf<Expense>()
    private var nextId = 1

    val expenses: List<Expense> get() = _expenses.toList()

    init {
        loadTestData()
    }

    private fun loadTestData() {
        addExpense("Продукты в Пятёрочке", 1240.50, ExpenseCategory.FOOD)
        addExpense("Обед в столовой", 320.0, ExpenseCategory.FOOD)
        addExpense("Кофе с собой", 189.0, ExpenseCategory.FOOD)
        addExpense("Перевод маме", 5000.0, ExpenseCategory.TRANSFERS)
        addExpense("Такси до университета", 415.0, ExpenseCategory.TAXI)
        addExpense("Такси домой", 560.0, ExpenseCategory.TAXI)
        addExpense("Кино", 650.0, ExpenseCategory.ENTERTAINMENTS)
        addExpense("Подписка на музыку", 199.0, ExpenseCategory.ENTERTAINMENTS)
        addExpense("Аптека", 870.0, ExpenseCategory.HEALTH)
        addExpense("Проездной на месяц", 2000.0, ExpenseCategory.TRANSPORT)
        addExpense("Метро", 57.0, ExpenseCategory.TRANSPORT)
        addExpense("Канцелярия", 340.0, ExpenseCategory.OTHER)
    }

    fun addExpense(
        title: String,
        amount: Double,
        category: ExpenseCategory
    ) {
        _expenses.add(Expense(id = nextId++, title, amount, category))
    }

    fun deleteExpense(removableExpense: Expense) {
        _expenses.remove(removableExpense)
    }

    fun getTotalAmount(): Double {
        var sum = 0.0

        for (expense in _expenses) sum += expense.amount

        return sum
    }

    fun getAmountByCategory() : Map<ExpenseCategory, Double> {
        val result = mutableMapOf<ExpenseCategory, Double>()

        for (expense in _expenses) {
            result[expense.category] = (result[expense.category] ?: 0.0) + expense.amount
        }

        return result
    }
}