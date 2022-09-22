package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.TransWalletHr;
import com.example.case_modul6.model.before.TransactionWallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransWalletHrRepo extends CrudRepository<TransWalletHr,Integer>{

    @Query(nativeQuery = true,value = "select * from case_module_6.trans_wallet_hr where enterprise_id_enterprise=:id")
    List<TransWalletHr> getAllTransWalletByIdEnter(@Param("id") int id);


    @Query(nativeQuery = true,value = "select * from case_module_6.trans_wallet_hr where  date_trans=:date")
    List<TransWalletHr> getAllTransWalletDateNow(@Param("date") String date);

    @Query(nativeQuery = true,value = "select SUM(money_away) from trans_wallet_hr where  date_trans=:date")
    double  totalMoneyTransDateNow(@Param("date") String date);

}
