package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.ViAdmin;
import org.springframework.data.repository.query.Param;

public interface IViAdminService {
    double getMoneyViAdmin();
    void setMoneyViAdmin(double number);
    String getPassViAdmin();


    ViAdmin getViAdmin();

    int percentDiscount(double money);
}
