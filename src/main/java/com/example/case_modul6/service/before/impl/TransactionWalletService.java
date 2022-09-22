package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.TransactionWallet;
import com.example.case_modul6.repository.before.ITransactionWalletRepo;
import com.example.case_modul6.service.before.InterfaceService.All.ITransactionWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionWalletService implements ITransactionWalletService {

    @Autowired
    ITransactionWalletRepo transactionWalletRepo;
    @Override
    public void save(TransactionWallet transactionWallet) {
        transactionWalletRepo.save(transactionWallet);
    }

    @Override
    public List<TransactionWallet> transactionWalletAll() {
        return (List<TransactionWallet>) transactionWalletRepo.findAll();
    }

    @Override
    public TransactionWallet transactionById(int id) {
        return transactionWalletRepo.findById(id).get();
    }

    @Override
    public void setStatusConfirmTransWallet(int id) {
        transactionWalletRepo.setStatusConfirmTransWallet(id);
    }
}
