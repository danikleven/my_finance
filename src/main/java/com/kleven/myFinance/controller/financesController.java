package com.kleven.myFinance.controller;

import com.kleven.myFinance.finances.DataRegisterFinances;
import com.kleven.myFinance.finances.Finance;
import com.kleven.myFinance.finances.FinancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finances")
public class financesController {

    @Autowired
    private FinancesRepository repository;

    @PostMapping
    public void register(@RequestBody DataRegisterFinances finance){
        repository.save(new Finance(finance));

    }
}
