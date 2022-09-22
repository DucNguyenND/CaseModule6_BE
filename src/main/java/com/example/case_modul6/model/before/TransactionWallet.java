package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class TransactionWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Enterprise enterprise;

    private double numberMoney;

    private String imgTransaction;

    private Time  timeTransaction;

    private Date dateTransaction;

    private boolean statusConfirm;


}
