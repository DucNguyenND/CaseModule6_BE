package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Enterprise enterprise;

    private Time timeTransaction;

    private Date dateTransaction;

    private int moneyTransaction;

    public TransactionHistory() {
    }

    public TransactionHistory(Enterprise enterprise, Time timeTransaction, Date dateTransaction, int moneyTransaction) {
        this.enterprise = enterprise;
        this.timeTransaction = timeTransaction;
        this.dateTransaction = dateTransaction;
        this.moneyTransaction = moneyTransaction;
    }
}
