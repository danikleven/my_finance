package com.kleven.myFinance.controller;

import com.kleven.myFinance.com.kleven.myFinance.error.ErrorMenssage;
import com.kleven.myFinance.expenses.DataRegisterExpenses;
import com.kleven.myFinance.expenses.DataToUpdateExpenses;
import com.kleven.myFinance.expenses.Expense;
import com.kleven.myFinance.expenses.ExpensesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class expensesController {

    @Autowired
    private ExpensesRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterExpenses expenses){
        repository.save(new Expense(expenses));
    }

    @GetMapping
    public Page<DataRegisterExpenses> list(@PageableDefault(size=10, sort={"detailing"}) Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DataRegisterExpenses::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getExensesById(@PathVariable Long id){
        Expense expense = repository.findById(id).orElse(null);
        if (expense != null){
            DataRegisterExpenses dataRegisterExpenses = new DataRegisterExpenses(expense);
            return ResponseEntity.ok(dataRegisterExpenses);
        } else {
            String errorMessage = "id not found!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMenssage(errorMessage));
        }
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid DataToUpdateExpenses data){
        var expenses = repository.getReferenceById(data.id());
        expenses.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var expenses = repository.getReferenceById(id);
        expenses.delete();
    }
}
