package com.kleven.myFinance.expenses;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DataToUpdateExpenses(
        @NotNull
        Long id,
        String detailing,
        String amount,
        Date expensesDate) {
}
