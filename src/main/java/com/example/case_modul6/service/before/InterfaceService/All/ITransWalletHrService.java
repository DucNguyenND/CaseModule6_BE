package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.TransWalletHr;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransWalletHrService {

    void save(TransWalletHr transWalletHr);

    List<TransWalletHr> findAllTransWalletHr();
    List<TransWalletHr> getAllTransWalletByIdEnter( int id);
    List<TransWalletHr> getAllTransWalletDateNow(  );
    double  totalMoneyTransDateNow();


}
