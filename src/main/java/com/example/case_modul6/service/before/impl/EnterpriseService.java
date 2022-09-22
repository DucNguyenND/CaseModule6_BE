package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.repository.before.IAppUserRepo;
import com.example.case_modul6.repository.before.IEnterpriseRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService implements IEnterpriseService {
    @Autowired
    IEnterpriseRepo enterpriseRepo;

@Autowired
IAppUserRepo iAppUserRepo;
    @Override
    public void save(Enterprise enterprise){

        enterpriseRepo.save(enterprise);
    }

    @Override
    public List<Enterprise> getAllEnterprise() {
       return (List<Enterprise>) enterpriseRepo.findAll();
    }

    @Override
    public List<Enterprise> getAllEnterpriseNotConfirmOrderByTime() {
        return enterpriseRepo.getAllEnterpriseNotConfirmOrderByTime();
    }

    @Override
    public List<Enterprise> getAllEnterpriseOrderByVi() {
        return enterpriseRepo.getAllEnterpriseOrderByVi();
    }

    @Override
    public Enterprise findEnterpriseById(int id) {
        return enterpriseRepo.findById(id).get();
    }

    @Override
    public void confirmRegisterEnterprise(String password, String codeVi,String numberVi, int status, int id) {
        enterpriseRepo.confirmRegisterEnterprise(password,codeVi,numberVi,status,id);
    }
    @Override
    public void delete(int id){
        enterpriseRepo.deleteById(id);
    }
    @Override
    public void rechargeWallet(int id, double numberMoney){
         enterpriseRepo.rechargeWallet(id,numberMoney);
    }
    @Override
    public double getMoneyViEnterpriseById(int id) {
        return enterpriseRepo.getMoneyViEnterpriseById(id);
    }

    @Override
    public void changeCodeVi(int id, String codeVi){
        enterpriseRepo.changeCodeVi(id,codeVi);
    }
    @Override
    public void setStatusEnterpriseTo1(int id) {
        enterpriseRepo.setStatusEnterpriseTo1(id);
    }
    @Override
    public void setStatusEnterpriseTo0(int id) {
        enterpriseRepo.setStatusEnterpriseTo0(id);
    }
// ĐỔi mật khẩu
    @Override
    public void changPassword(String email, String password) {
        iAppUserRepo.changPassword(email,password);
    }

    @Override
    public void setViEnterprise(int id, double numberMoney){
         enterpriseRepo.setViEnterprise(id,numberMoney);
    }

    @Override
    public void setRatesByEnterprise(int id,double rates) {
        enterpriseRepo.setRatesByEnterprise(id,rates);
    }

    @Override
    public List<Enterprise> listEnterpriseOderByRates() {
        return enterpriseRepo.listEnterpriseOderByRates();
    }

    @Override
    public Enterprise findByGmailEnterprise(String name){
        return enterpriseRepo.findByGmailEnterprise(name);
    }

    @Override
    public double findViByIdEnterprise(int id){
        return enterpriseRepo.findViByIdEnterprise(id);
    }
}
