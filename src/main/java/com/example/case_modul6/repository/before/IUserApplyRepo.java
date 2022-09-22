package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.UserApply;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserApplyRepo extends CrudRepository<UserApply,Integer> {

    @Query(nativeQuery = true,value = "select * from case_module_6.user_apply where (imgcv=:imgcv or  mail_cv=:mail_cv or  numbercv=:numbercv) and  app_user_id=:idAppUser and post_enterprise_id_post_enterprise=:idPost")
     UserApply findByIdAppUserAndIdPost(@Param("imgcv")String imgcv,@Param("mail_cv") String mail_cv,@Param("numbercv") String number_cv,@Param("idAppUser") int idAppUser, @Param("idPost") int idPost);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update case_module_6.user_apply set status_confirm=1 where id_user_apply=:id")
    void updateStatusConfirmUserApply(@Param("id") int id);

    @Query(nativeQuery = true,value = "select * from case_module_6.user_apply where post_enterprise_id_post_enterprise=:id")
    List<UserApply> listUserApplyByIdPost(@Param("id") int id);

    @Query(nativeQuery = true,value = "select post_enterprise_id_post_enterprise from case_module_6.user_apply where app_user_id=:id")
    List<Integer> listIdPostByIdUserApply(@Param("id") int id);

    @Query(nativeQuery = true, value = "select * from case_module_6.user_apply where app_user_id=:id")
    List<UserApply> listUserApplyByIdAppUser(@Param("id") int id);
    @Query(nativeQuery = true,value = "select * from user_apply where app_user_id=:idUser and post_enterprise_id_post_enterprise=:idPost")
    UserApply findImgCvApply(@Param("idUser")int idUser,@Param("idPost")int idPost);
}
