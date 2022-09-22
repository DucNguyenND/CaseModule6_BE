package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CvUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    AppUser appUser;

    private String name;

    private String mail;

    private String telephone;

    private String imgCV;

}
