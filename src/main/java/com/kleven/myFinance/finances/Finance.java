package com.kleven.myFinance.finances;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Table(name = "finances")
@Entity(name = "Finance")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detailing;
    private String amount;
    private Date financeDate;

    private boolean active;

    public Finance(DataRegisterFinances finances){
        this.active = true;
        this.detailing = finances.detailing();
        this.amount = finances.amount();
        this.financeDate = finances.financeDate();
    }

    public void update(DataToUpdateFinance data){
        if(data.detailing() != null){
            this.detailing = data.detailing();
        }
        if(data.amount() != null){
            this.amount = data.amount();
        }
        if(data.financeDate() != null){
            this.financeDate = data.financeDate();
        }
    }

    public void delete(){
        this.active = false;
    }

}
