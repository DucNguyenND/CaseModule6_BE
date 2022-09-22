package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.TransactionHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionHistoryRepo extends CrudRepository<TransactionHistory,Integer> {
    @Query(nativeQuery = true,value = "SELECT SUM(money_transaction)FROM case_module_6.transaction_history")
    int totalTransaction();

    @Query(nativeQuery = true,value = "SELECT SUM(money_transaction)FROM case_module_6.transaction_history where enterprise_id_enterprise=:id")
    int totalTransactionByEnterprise(@Param("id") int id);
    
    @Query(nativeQuery = true,value = "select * from case_module_6.transaction_history where date_transaction=:date")
    List<TransactionHistory> listTransactionHistoryByDateNow(@Param("date") String date);

    @Query(nativeQuery = true,value = "select * from case_module_6.transaction_history where enterprise_id_enterprise=:id limit 1")
    TransactionHistory checkExist(@Param("id") int id);
}
