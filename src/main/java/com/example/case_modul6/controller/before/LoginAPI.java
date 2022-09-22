package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.AppUser;

import com.example.case_modul6.model.before.ChangePassWord;
import com.example.case_modul6.model.before.ot.UserToken;

import com.example.case_modul6.service.JwtService;

import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import com.example.case_modul6.service.before.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    AppUserService appUserService;

    @Autowired
    IEnterpriseService enterpriseService;
    @PostMapping("/login")
    public UserToken login(@RequestBody AppUser appUser){
        try{
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(appUser.getUsername());
            return new UserToken(appUser1.getId(),appUser1.getUsername(),token, appUser1.getRoles());
        }catch (Exception e) {
            return null;
        }
    }
    @GetMapping("/findByName/{name}")
    public ResponseEntity<AppUser> findByUserName(@PathVariable String name){
        return new ResponseEntity<>(appUserService.findByUserName(name),HttpStatus.OK);
    }
    @PostMapping("/changePassword")
    public ResponseEntity<AppUser> changePassword(@RequestBody ChangePassWord changePassWord ) {
        enterpriseService.changPassword(changePassWord.getGmail(), changePassWord.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
  }
