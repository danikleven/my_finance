package com.kleven.myFinance.expenses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DataRegisterExpenses(

        Long id,
        @NotBlank
        String detailing,
        @NotBlank
        @NotBlank
        String amount,
        @NotNull
        Date expensesDate) {

        public DataRegisterExpenses(Expense expense){
                this(expense.getId(), expense.getDetailing(), expense.getAmount(), expense.getExpensesDate());
        }
}
