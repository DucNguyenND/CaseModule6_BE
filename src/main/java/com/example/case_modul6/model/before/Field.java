package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Field {
    @Id
    private int idField;

    private String nameField;
}
