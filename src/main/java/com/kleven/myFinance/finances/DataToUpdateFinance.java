package com.kleven.myFinance.finances;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DataToUpdateFinance(
        @NotNull
        Long id,
        String detailing,
        String amount,
        Date financeDate) {
}
