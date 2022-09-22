package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.TransactionWallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ITransactionWalletRepo extends CrudRepository<TransactionWallet,Integer>{

   @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update transaction_wallet set status_confirm=1 where id=:id")
    void  setStatusConfirmTransWallet(@Param("id") int id);
}
