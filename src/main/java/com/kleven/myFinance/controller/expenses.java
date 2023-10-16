package com.kleven.myFinance.controller;

import com.kleven.myFinance.expenses.DataRegisterExpenses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class expenses {

    @PostMapping
    public void register(@RequestBody DataRegisterExpenses expenses){
        System.out.println(expenses);
    }
}
