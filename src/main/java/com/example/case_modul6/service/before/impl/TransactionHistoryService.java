package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.TransactionHistory;
import com.example.case_modul6.repository.before.ITransactionHistoryRepo;
import com.example.case_modul6.service.before.InterfaceService.All.ITransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionHistoryService implements ITransactionHistoryService {

    @Autowired
   ITransactionHistoryRepo transactionHistoryRepo;


    @Override
    public void save(TransactionHistory transactionHistory) {
        transactionHistoryRepo.save(transactionHistory);
    }

    @Override
    public List<TransactionHistory> listTransactionHistory() {
        return (List<TransactionHistory>) transactionHistoryRepo.findAll();
    }

    @Override
    public int totalTransaction() {
        return transactionHistoryRepo.totalTransaction();
    }
    @Override
    public int totalTransactionByEnterprise(int id) {
        return transactionHistoryRepo.totalTransactionByEnterprise(id);
    }
    @Override
    public List<TransactionHistory> listTransactionHistoryByDateNow(String date){
        return transactionHistoryRepo.listTransactionHistoryByDateNow(date);
    }

    @Override
    public TransactionHistory checkExist(int id) {
        return transactionHistoryRepo.checkExist(id);
    }

}
