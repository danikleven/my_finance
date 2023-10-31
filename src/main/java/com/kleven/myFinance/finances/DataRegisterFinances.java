package com.kleven.myFinance.finances;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DataRegisterFinances(

        Long id,
        @NotBlank
        String detailing,
        @NotBlank
        String amount,
        @NotNull
        Date financeDate) {

        public DataRegisterFinances(Finance finance){
                this(finance.getId(), finance.getDetailing(), finance.getAmount(), finance.getFinanceDate());
        }
}
