package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    void save(Enterprise enterprise);

    List<Enterprise> getAllEnterprise();

    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();

    List<Enterprise> getAllEnterpriseOrderByVi();

    Enterprise findEnterpriseById(int id);

    Enterprise findByGmailEnterprise(String name);

    double findViByIdEnterprise(int id);

    void confirmRegisterEnterprise(String password, String codeVi, String numberVi, int status, int id);

    void delete(int id);

    void rechargeWallet(int id, double numberMoney);

    double getMoneyViEnterpriseById(int id);

    void changeCodeVi(int id, String codeVi);

    void setViEnterprise(int id, double numberMoney);

    void setRatesByEnterprise(int id, double rates);

    List<Enterprise> listEnterpriseOderByRates();

//    the

//    tuan

    //    song
    void setStatusEnterpriseTo1(int id);
    void setStatusEnterpriseTo0(int id);

    void changPassword(String email, String password);

//    hai

//    duc

}
