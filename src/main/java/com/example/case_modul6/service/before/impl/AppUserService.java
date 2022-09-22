package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.AppUser;
import com.example.case_modul6.repository.before.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return new User(appUser.getUsername(), appUser.getPassword(), Collections.singleton(appUser.getRoles()));
    }
    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
       return  iAppUserRepo.findByUsername(username);
    }
    public AppUser save(AppUser appUser){
        return iAppUserRepo.save(appUser);
    }


}
