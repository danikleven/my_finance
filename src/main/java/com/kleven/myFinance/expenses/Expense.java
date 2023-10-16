package com.kleven.myFinance.expenses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "expenses")
@Entity(name = "Expense")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String amount;
    private String date;

    public Expense(DataRegisterExpenses expenses){
        this.description = expenses.description();
        this.amount = expenses.amount();
        this.date = expenses.date();
    }
}
