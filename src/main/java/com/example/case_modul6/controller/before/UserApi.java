package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.CvUser;
import com.example.case_modul6.model.before.FindPostByUser;
import com.example.case_modul6.model.before.Notification.NotificationEnterprise;
import com.example.case_modul6.model.before.PostEnterprise;
import com.example.case_modul6.model.before.UserApply;
import com.example.case_modul6.service.before.InterfaceService.All.ICvUserService;
import com.example.case_modul6.service.before.InterfaceService.All.INotificationEnterpriseService;
import com.example.case_modul6.service.before.InterfaceService.All.IUserApplyService;
import com.example.case_modul6.service.before.impl.CvUserService;
import com.example.case_modul6.service.before.impl.PostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserApi {

    @Autowired
    PostEnterpriseService postEnterpriseService;
    @Autowired
    ICvUserService cvUserService;

    @Autowired
    IUserApplyService userApplyService;

    @Autowired
    INotificationEnterpriseService notificationEnterpriseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostEnterprise>> findAll() {
        return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }
    @RequestMapping("/getAll/{page}")
    public ResponseEntity<List<PostEnterprise>> findAll(@PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.getAll(PageRequest.of(page, 3)), HttpStatus.OK);
    }

    @GetMapping("/listPostByOderPriority/{id}/{page}")
    public ResponseEntity<List<PostEnterprise>> listPostByOderPriority(@PathVariable int id,@PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.listPostByOderPriority(id,PageRequest.of(page-1, 3)), HttpStatus.OK);
    }

    //    Tạo Cv
    @PostMapping("/saveCvUser")
    public ResponseEntity<CvUser> saveCvUser(@RequestBody CvUser cvUser) {
        cvUserService.save(cvUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //  a song tìm kiếm
    @GetMapping("/findAddress/{address}")
    public ResponseEntity<List<PostEnterprise>> findByAddress(@PathVariable String address) {
        return new ResponseEntity<>(postEnterpriseService.findByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/findByNamePost/{name}")
    public ResponseEntity<List<PostEnterprise>> findByNamePost(@PathVariable String name) {
        return new ResponseEntity<>(postEnterpriseService.findByNamePost(name), HttpStatus.OK);
    }

    @GetMapping("/findByEnterprise/{id}")
    public ResponseEntity<List<PostEnterprise>> findByEnterprise(@PathVariable int id) {
        return new ResponseEntity<>(postEnterpriseService.findByEnterprise(id), HttpStatus.OK);
    }

    @GetMapping("/findSalary/{salary}")
    public ResponseEntity<List<PostEnterprise>> findBySalary(@PathVariable double salary) {
        return new ResponseEntity<>(postEnterpriseService.findSalary(salary), HttpStatus.OK);
    }

    //    Lưu Cv
    @GetMapping("/findCvByIdUser/{id}")
    public ResponseEntity<CvUser> findCvByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(cvUserService.findByIdAppUser(id), HttpStatus.OK);
    }

    //Tuấn Chi tiết bài đăng
    @GetMapping("/postDetail/{id}")
    public ResponseEntity<PostEnterprise> findPostByID(@PathVariable int id) {
        return new ResponseEntity<>(postEnterpriseService.findById(id), HttpStatus.OK);
    }

    //    SaveApplyJob  -- Thế
    @PostMapping("/saveApplyJob")
    public ResponseEntity<UserApply> saveApplyJob(@RequestBody UserApply userApply) {
        int idAppUser = userApply.getAppUser().getId();
        int idPost = userApply.getPostEnterprise().getIdPostEnterprise();
        String telephoneCV = cvUserService.findByIdAppUser(idAppUser).getTelephone().trim();
        String mail = cvUserService.findByIdAppUser(idAppUser).getMail().trim();
        String imgCv = cvUserService.findByIdAppUser(idAppUser).getImgCV().trim();
        UserApply userApply1 = userApplyService.findByIdAppUserAndIdPost(imgCv, mail, telephoneCV, idAppUser, idPost);
        if (userApply1 == null) {
            userApplyService.save(userApply);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/findUserApplyByIdAppUserAndIdPost/{idAppUser}/{idPost}")
    public ResponseEntity<UserApply> findByIdAppUserAndIdPost(@PathVariable int idAppUser, @PathVariable int idPost) {
        String telephoneCV = cvUserService.findByIdAppUser(idAppUser).getTelephone().trim();
        String mail = cvUserService.findByIdAppUser(idAppUser).getMail().trim();
        String imgCv = cvUserService.findByIdAppUser(idAppUser).getImgCV().trim();
        return new ResponseEntity<UserApply>(userApplyService.findByIdAppUserAndIdPost(imgCv, mail, telephoneCV, idAppUser, idPost), HttpStatus.OK);
    }

    @PostMapping("/findPostUser")
    public ResponseEntity<List<PostEnterprise>> findPostUser(@RequestBody FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService.findPostUser(findPostByUser.getNameEnterprise(), findPostByUser.getCity(), findPostByUser.getIdField()), HttpStatus.OK);
    }

    @PostMapping("/findPostUserField")
    public ResponseEntity<List<PostEnterprise>> findPostUserField(@RequestBody FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService.findPostUserField(findPostByUser.getNameEnterprise(), findPostByUser.getCity()), HttpStatus.OK);
    }

    //    Xóa bài đăng khi hết hạn
    @GetMapping("/deletePostExpired")
    public ResponseEntity<Boolean> deletePostExpired() {
        postEnterpriseService.deletePostExpired();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/listUserApplyByIdAppUser/{id}")
    public ResponseEntity<List<PostEnterprise>> findUserApply(@PathVariable int id){
        return new ResponseEntity<>(postEnterpriseService.findPostByUserApply(id),HttpStatus.OK);
    }
    @GetMapping("/findImgCvApply/{idUser}/{idPost}")
    public ResponseEntity<UserApply> findImgCvApply(@PathVariable int idUser,@PathVariable int idPost){
        return new ResponseEntity<>(userApplyService.findImgCvApply(idUser,idPost),HttpStatus.OK);}
}
