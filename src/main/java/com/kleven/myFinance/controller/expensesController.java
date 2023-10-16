package com.kleven.myFinance.controller;

import com.kleven.myFinance.expenses.DataRegisterExpenses;
import com.kleven.myFinance.expenses.Expense;
import com.kleven.myFinance.expenses.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class expensesController {

    @Autowired
    private ExpensesRepository repository;

    @PostMapping
    public void register(@RequestBody DataRegisterExpenses expenses){
        repository.save(new Expense(expenses));
    }
}
