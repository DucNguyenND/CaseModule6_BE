package com.example.case_modul6.repository.before;

import com.example.case_modul6.model.before.Enterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface IPostEnterpriseRepo extends PagingAndSortingRepository<PostEnterprise, Integer> {
    @Query(nativeQuery = true,value = "select  * from case_module_6.post_enterprise")
    List<PostEnterprise> getAll(Pageable pageable);
    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where id_post_enterprise=:id")
    List<PostEnterprise> findAllById(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id")
    List<PostEnterprise> findAllByIdEnterprise(@Param("id") int id);

//    select * from post_enterprise where id_post_enterprise not in
//            (select post_enterprise_id_post_enterprise from user_apply
//                    where app_user_id = 3)
    @Query(nativeQuery = true, value = " select * from post_enterprise where id_post_enterprise not in\n" +
            "            (select post_enterprise_id_post_enterprise from user_apply\n" +
            "                    where app_user_id =:id ) having status_post_enterprise=1 order by priority_post_enterprise DESC ")
    List<PostEnterprise> listPostByOderPriority(@Param("id")int id, Pageable pageable);

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=1")
    List<PostEnterprise> listPostVipByEnterprise(@Param("id") int id);

    @Query(nativeQuery = true, value = "select  * from case_module_6.post_enterprise where enterprise_id_enterprise=:id and regime_id_regime=2")
    List<PostEnterprise> listPostThuongByEnterprise(@Param("id") int id);

    // Song Đạt tìm kiếm bài đăng theo địa chỉ và công ty
    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where address_main_enterprise LIKE %:address% ")
    List<PostEnterprise> findByAddress(@Param("address") String address);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where enterprise_id_enterprise=:id_enterprise")
    List<PostEnterprise> findByEnterprise(@Param("id_enterprise") int id);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where name_post_enterprise LIKE %:name%")
    List<PostEnterprise> findByNamePost(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where salary_big_post_enterprise between  salary_small_post_enterprise AND  salary_big_post_enterprise ")
    List<PostEnterprise> findSalary(double salary);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 0 where  id_post_enterprise=:id ")
    void statusPost( @Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update post_enterprise set status_post_enterprise = 1 where  id_post_enterprise=:id ")
    void openKeyPost( @Param("id") int id);


    //edit bài viết
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE post_enterprise SET address_main_enterprise =:addressMainEnterprise, describe_post_enterprise =:describePostEnterprise, name_post_enterprise =:namePostEnterprise, salary_big_post_enterprise =:salaryBigPostEnterprise, salary_small_post_enterprise =:salarySmallPostEnterprise, vacancies_post_enterprise =:vacanciesPostEnterprise, field_id_field =:id, form_job_post_enterprise_id_form_job =:formJobPostEnterpriseid WHERE id_post_enterprise =:idPostEnterprise ")
    void editPost( @Param("addressMainEnterprise") String addressMainEnterprise,@Param("describePostEnterprise") String describePostEnterprise,@Param("namePostEnterprise") String namePostEnterprise,@Param("salaryBigPostEnterprise") double salaryBigPostEnterprise,@Param("salarySmallPostEnterprise") double salarySmallPostEnterprise,@Param("vacanciesPostEnterprise") String vacanciesPostEnterprise,@Param("id") int idfield,@Param("formJobPostEnterpriseid") int formJobPostEnterpriseid,@Param("idPostEnterprise") int idPostEnterprise);

//     số lượng apply theo post
    @Query(nativeQuery = true,value = "select quantity_apply_post from case_module_6.post_enterprise where  id_post_enterprise=:id ")
    int quantityApplyByIdPost(@Param("id") int id);

//    update số lượng apply theo post
     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "update post_enterprise set quantity_apply_post=:quantity where id_post_enterprise=:id ")
    void setQuantityApplyPost(@Param("id") int id,@Param("quantity") int quantity);
// lấy và chỉnh sửa  điểm đề xuất của bài post theo id
    @Query(nativeQuery = true,value = "select  priority_post_enterprise from case_module_6.post_enterprise where id_post_enterprise=:id")
    int priorityByIdPost(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update post_enterprise set priority_post_enterprise=:quantity where id_post_enterprise=:id ")
    void setPriorityIdPost(@Param("quantity") int quantity,@Param("id") int id);


//    Thực hiện xóa bài viết khi hết hạn !
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "delete  from case_module_6.post_enterprise where expiration_date_post_enterprise=:date ")
    void  deletePostExpired(@Param("date") String date);

//    lấy tất cả bài đăng của ngày hiện tại
    @Query(nativeQuery = true,value = "select * from case_module_6.post_enterprise where expiration_date_post_enterprise=:date limit 1")
    PostEnterprise getPostExpired(@Param("date") String date);
    // Tìm kiếm bài viết theo lĩnh vực tên công việc, thành phố

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where name_post_enterprise LIKE %:name% && address_main_enterprise LIKE %:address% && field_id_field=:field  ")
    List<PostEnterprise> findPostUser(@Param("name") String name, @Param("address") String address, @Param("field") int id);

    @Query(nativeQuery = true, value = "select * from case_module_6.post_enterprise where name_post_enterprise LIKE %:name% && address_main_enterprise LIKE %:address%  ")
    List<PostEnterprise> findPostUserfield(@Param("name") String name, @Param("address") String address);

    @Query(nativeQuery = true ,value = "select * from post_enterprise where id_post_enterprise in\n" +
            "(select post_enterprise_id_post_enterprise from user_apply\n" +
            "where app_user_id = :id)")
    public  List<PostEnterprise> searchPostApplyByUser(@Param("id") int id);
}
