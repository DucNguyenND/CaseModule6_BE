package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.ViAdmin;
import com.example.case_modul6.repository.before.IViAdminRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IViAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViAdminService implements IViAdminService {
    @Autowired
    IViAdminRepo viAdminRepo;
    @Override
    public double getMoneyViAdmin() {
        return viAdminRepo.getMoneyViAdmin();
    }

    @Override
    public void setMoneyViAdmin(double number) {
            viAdminRepo.setMoneyViAdmin(number);
    }

    @Override
    public String getPassViAdmin() {
        return viAdminRepo.getPassViAdmin();
    }

    @Override
    public ViAdmin getViAdmin() {
        return viAdminRepo.findById(1).get();
    }

    @Override
    public int percentDiscount(double money) {
        if(money<20){
            return 10;
        }
        else if(money<50){
            return 6;
        }else {
            return 3;
        }
    }


}
