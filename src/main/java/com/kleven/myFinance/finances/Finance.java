package com.kleven.myFinance.finances;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
    private String description;
    private String amount;
    private String date;

    public Finance(DataRegisterFinances finances){
        this.description = finances.description();
        this.amount = finances.amount();
        this.date = finances.date();
    }
}
