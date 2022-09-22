package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.TransactionWallet;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionWalletService{

    void save(TransactionWallet transactionWallet);

    List<TransactionWallet> transactionWalletAll();

    TransactionWallet transactionById(int id);
    void  setStatusConfirmTransWallet(int id);
}
