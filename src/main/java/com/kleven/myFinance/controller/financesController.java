package com.kleven.myFinance.controller;

import com.kleven.myFinance.com.kleven.myFinance.error.ErrorMenssage;
import com.kleven.myFinance.finances.DataRegisterFinances;
import com.kleven.myFinance.finances.DataToUpdateFinance;
import com.kleven.myFinance.finances.Finance;
import com.kleven.myFinance.finances.FinancesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/finances")
public class financesController {

    @Autowired
    private FinancesRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterFinances finance){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(finance.financeDate());

        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("Detailing: " + finance.detailing() + " Month: " + month);
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();


        repository.save(new Finance(finance));
    }


    @GetMapping
    public Page<DataRegisterFinances> list(@PageableDefault(size=10, sort={"detailing"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(DataRegisterFinances::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFinanceByid(@PathVariable Long id){
        Finance finance = repository.findById(id).orElse(null);
        if(finance != null){
           DataRegisterFinances dataRegisterFinances = new DataRegisterFinances(finance);
           return ResponseEntity.ok(dataRegisterFinances);
        } else {
            String errorMessage = "id not found!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMenssage(errorMessage));
        }
    }

    @PutMapping
    @Transactional
    public void update (@RequestBody @Valid DataToUpdateFinance data){
        var finance = repository.getReferenceById(data.id());
        finance.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete (@PathVariable Long id){
        var finance = repository.getReferenceById(id);
        finance.delete();
    }
}
