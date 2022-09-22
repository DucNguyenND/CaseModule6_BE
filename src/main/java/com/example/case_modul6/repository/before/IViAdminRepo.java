package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.ViAdmin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IViAdminRepo extends CrudRepository<ViAdmin,Integer> {
    @Query(nativeQuery = true,value = "select number_money_vi from case_module_6.vi_admin where id=1")
     double getMoneyViAdmin();
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE case_module_6.vi_admin SET number_money_vi=:number  where id=1")
    void setMoneyViAdmin(@Param("number") double number);

    @Query(nativeQuery = true,value = "select password_vi from case_module_6.vi_admin where id=1")
    String getPassViAdmin();
}
