package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEnterpriseRepo extends CrudRepository<Enterprise,Integer>{

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update enterprise set password_enterprise=:password,code_vi_enterprise=:codeVi,status_confirm=:status,number_vi_enterprise=:numberVi where id_enterprise=:id")
    void confirmRegisterEnterprise(@Param("password") String password,@Param("codeVi") String codeVi,@Param("numberVi") String numberVi,@Param("status") int status,@Param("id")int id);
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where status_confirm=0 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where status_confirm=1 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseOrderByVi();

    @Query(nativeQuery = true,value = "SELECT vi_enterprise FROM case_module_6.enterprise where id_enterprise=:id")
    double findViByIdEnterprise(@Param("id") int id);
    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where gmail_enterprise=:gmail")
    Enterprise findByGmailEnterprise(@Param("gmail") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set vi_enterprise=:numberMoney where id_enterprise=:id")
   void rechargeWallet(@Param("id") int id,@Param("numberMoney") double numberMoney);

    @Query(nativeQuery = true,value = "SELECT vi_enterprise FROM case_module_6.enterprise  where id_enterprise=:id")
    double getMoneyViEnterpriseById(@Param("id")int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set code_vi_enterprise=:codeVi where id_enterprise=:id")
    void changeCodeVi(@Param("id") int id,@Param("codeVi") String codeVi);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set status_enterprise=1 where id_enterprise=:id")
    void setStatusEnterpriseTo1(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set status_enterprise=1 where id_enterprise=:id")
    void setStatusEnterpriseTo0(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set vi_enterprise=:numberMoney where id_enterprise=:id")
    void setViEnterprise(@Param("id") int id,@Param("numberMoney") double numberMoney);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.enterprise set rates_enterprise=:rates where id_enterprise=:id")
    void setRatesByEnterprise(@Param("id") int id,@Param("rates") double rates);


    @Query(nativeQuery = true,value = "SELECT * FROM case_module_6.enterprise where status_confirm=1 order by rates_enterprise desc")
    List<Enterprise> listEnterpriseOderByRates();












}
