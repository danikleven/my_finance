package com.kleven.myFinance.controller;

import com.kleven.myFinance.finances.DataRegisterFinances;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finances")
public class finances {

    @PostMapping
    public void register(@RequestBody DataRegisterFinances finance){
        System.out.println(finance);
    }
}
