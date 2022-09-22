package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
public class TransWalletHr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private ViAdmin viAdmin;

    @ManyToOne
    private Enterprise enterprise;

    private double moneyReceive;

    private double moneyAway;

    private double moneyDiscount;

    private Date dateTrans;

    private Time timeTrans;

    public TransWalletHr() {
    }

    public TransWalletHr( ViAdmin viAdmin, Enterprise enterprise, double moneyReceive, double moneyAway, double moneyDiscount, Date dateTrans, Time timeTrans) {
        this.viAdmin = viAdmin;
        this.enterprise = enterprise;
        this.moneyReceive = moneyReceive;
        this.moneyAway = moneyAway;
        this.moneyDiscount = moneyDiscount;
        this.dateTrans = dateTrans;
        this.timeTrans = timeTrans;
    }
}
