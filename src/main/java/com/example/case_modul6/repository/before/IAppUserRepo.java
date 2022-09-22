package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.AppUser;
import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);


    // ĐỔi mật khẩu
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update  case_module_6.app_user set password=:password where email=:email")
    void changPassword(@Param("email") String gmail,@Param("password") String password);



}
