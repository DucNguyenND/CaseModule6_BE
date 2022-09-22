package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.FormJob;
import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.model.before.Regime;
import com.example.case_modul6.repository.before.IFormJobRepo;
import com.example.case_modul6.repository.before.IPostEnterpriseRepo;
import com.example.case_modul6.repository.before.IRegimeRepo;
import com.example.case_modul6.repository.before.IUserApplyRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IPostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PostEnterpriseService implements IPostEnterpriseService {

    @Autowired
    IPostEnterpriseRepo postEnterpriseRepo;

    @Autowired
    IFormJobRepo formJobRepo;
    @Autowired
    IRegimeRepo regimeRepo;
    @Autowired
    IUserApplyRepo userApplyRepo;

    @Override
    public List<PostEnterprise> findAll() {
        return (List<PostEnterprise>) postEnterpriseRepo.findAll();
    }

    @Override
    public List<PostEnterprise> getAll(Pageable pageable) {
        return postEnterpriseRepo.getAll(pageable);
    }

    @Override
    public List<PostEnterprise> findAllById(int id) {
        return postEnterpriseRepo.findAllById(id);
    }

    @Override
    public PostEnterprise findById(int id) {
        return postEnterpriseRepo.findById(id).get();
    }

    @Override
    public void save(PostEnterprise postEnterprise) {
        postEnterpriseRepo.save(postEnterprise);
    }

    @Override
    public void delete(int id) {
        postEnterpriseRepo.deleteById(id);
    }

    @Override
    public void editPost(PostEnterprise postEnterprise) {
        postEnterpriseRepo.editPost(postEnterprise.getAddressMainEnterprise(),postEnterprise.getDescribePostEnterprise(),postEnterprise.getNamePostEnterprise(),postEnterprise.getSalaryBigPostEnterprise(),postEnterprise.getSalarySmallPostEnterprise(),postEnterprise.getVacanciesPostEnterprise(),postEnterprise.getField().getIdField(),postEnterprise.getFormJobPostEnterprise().getIdFormJob(),postEnterprise.getIdPostEnterprise());
    }

// List chế độ bài đăng và hình thức công việc

    public List<FormJob> findAllFormJob() {
        return (List<FormJob>) formJobRepo.findAll();
    }

    public List<Regime> findAllRegime() {
        return (List<Regime>) regimeRepo.findAll();
    }

    @Override
    public List<PostEnterprise> findAllByIdEnterprise(int id) {
        return postEnterpriseRepo.findAllByIdEnterprise(id);
    }

    @Override
    public List<PostEnterprise> listPostByOderPriority(int idUserLogin,Pageable pageable) {

        return postEnterpriseRepo.listPostByOderPriority(idUserLogin,pageable);
    }

    @Override
    public List<PostEnterprise> listPostVipByEnterprise(int id) {
        return postEnterpriseRepo.listPostVipByEnterprise(id);
    }

    @Override
    public List<PostEnterprise> listPostThuongByEnterprise(int id){
        return postEnterpriseRepo.listPostThuongByEnterprise(id);
    }

    // Song Đạt tìm kiếm bài đăng theo địa chỉ và công ty
    public List<PostEnterprise> findByAddress(String address) {
        return postEnterpriseRepo.findByAddress(address);
    }

    public List<PostEnterprise> findByNamePost(String name) {
        return postEnterpriseRepo.findByNamePost(name);
    }

    public List<PostEnterprise> findByEnterprise(int id) {
        return postEnterpriseRepo.findByEnterprise(id);
    }

    public List<PostEnterprise> findSalary(double salary) {
        return postEnterpriseRepo.findSalary(salary);
    }

    public void statusPost(int id) {
        postEnterpriseRepo.statusPost(id);
    }

    @Override
    public void openKeyPost(int id) {
        postEnterpriseRepo.openKeyPost(id);
    }

    @Override
    public int quantityApplyByIdPost(int id) {
        return postEnterpriseRepo.quantityApplyByIdPost(id);
    }

    @Override
    public void setQuantityApplyPost(int id, int quantity) {
        postEnterpriseRepo.setQuantityApplyPost(id, quantity);
    }

    @Override
    public int priorityByIdPost(int id) {
        return postEnterpriseRepo.priorityByIdPost(id);
    }

    @Override
    public void setPriorityIdPost(int number, int id) {
        postEnterpriseRepo.setPriorityIdPost(number, id);
    }

    // Tìm kiếm bài viết theo tên, địa chỉ, lĩnh vực
    @Override
    public List<PostEnterprise> findPostUser(String name, String address, int field) {
        return postEnterpriseRepo.findPostUser(name, address, field);
    }
    public List<PostEnterprise> findPostUserField(String name, String address){
        return postEnterpriseRepo.findPostUserfield(name,address);
    }
    @Override
    public void deletePostExpired() {
        long millis = System.currentTimeMillis();
        java.sql.Date dateNow = new java.sql.Date(millis);
        String dateNowStr= String.valueOf(dateNow);
        if(getPostExpired(dateNowStr)!=null){
               postEnterpriseRepo.deletePostExpired(dateNowStr);
        }
        else {
            System.out.println("Không có !");
        }
    }

    @Override
    public PostEnterprise getPostExpired(String date) {
        return postEnterpriseRepo.getPostExpired(date);
    }

    public List<PostEnterprise> findPostByUserApply(int id){
        return postEnterpriseRepo.searchPostApplyByUser(id);
    }
}
