package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.TransactionHistory;

import java.util.List;

public interface ITransactionHistoryService {


    void save(TransactionHistory transactionHistory);

    List<TransactionHistory> listTransactionHistory();

    int totalTransaction();
    int totalTransactionByEnterprise(int id);

    List<TransactionHistory> listTransactionHistoryByDateNow(String date);
    TransactionHistory checkExist(int id);

}
