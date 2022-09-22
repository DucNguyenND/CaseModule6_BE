package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.CvUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICvUserRepo extends CrudRepository<CvUser,Integer>{
    @Query(nativeQuery = true, value = "SELECT * FROM case_module_6.cv_user where app_user_id=:id")
    CvUser findCvByAppUser(@Param("id") int id);
}
