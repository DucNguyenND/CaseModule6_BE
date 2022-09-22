package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.AppUser;
import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.Field;
import com.example.case_modul6.model.before.Role;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.IFieldService;
import com.example.case_modul6.service.before.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterAPI {

    @Autowired
    AppUserService appUserService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IFieldService fieldService;

    @PostMapping("/user")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
        Role role = new Role();
        role.setId(3);
        appUser.setRoles(role);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
//
    }
    @GetMapping("/findAllField")
    public ResponseEntity<List<Field>> findAllField(){
        return new ResponseEntity<>(fieldService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Field> findById(@PathVariable int id){
        return new ResponseEntity<>(fieldService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/enterprise")
    public ResponseEntity<Enterprise> registerEnterprise(@RequestBody Enterprise enterprise){
        enterprise.setTimeRegisterEnterprise(Time.valueOf(java.time.LocalTime.now()));
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        enterprise.setDateRegisterEnterprise(date);
        enterpriseService.save(enterprise);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/enterprise")
// Đức
   @GetMapping("/checkEnterprise")
     public ResponseEntity<List<Enterprise>> findAllEnterprise(){
    return new ResponseEntity<>(enterpriseService.getAllEnterprise(), HttpStatus.OK);
    }
    // Đức
    @GetMapping("/checkUser")
    public ResponseEntity<List<AppUser>> findAllUser(){
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }
}
