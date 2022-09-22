package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ViAdmin {
    @Id
    private int id=1;

    private String numberVi;

    private double numberMoneyVi;

    private String passwordVi;

}
