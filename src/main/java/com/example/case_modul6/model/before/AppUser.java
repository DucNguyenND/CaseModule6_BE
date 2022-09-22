package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private  String email;
    private String password;
//    @ManyToMany(fetch = FetchType.EAGER)
    @OneToOne
    private Role roles;
}
