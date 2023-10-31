package com.kleven.myFinance.expenses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @Column(nullable = false)
    private String detailing;
    @Column(nullable = false)
    private String amount;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date expensesDate;

    private boolean active;

    public Expense(DataRegisterExpenses expenses){
        this.active = true;
        this.detailing = expenses.detailing();
        this.amount = expenses.amount();
        this.expensesDate = expenses.expensesDate();
    }

    public void update(DataToUpdateExpenses data){
        if(data.detailing() != null){
            this.detailing = data.detailing();
        }
        if(data.amount() != null){
            this.amount = data.amount();
        }
        if(data.expensesDate() != null){
            this.expensesDate = data.expensesDate();
        }
    }

    public void delete(){
        this.active = false;
    }

}
