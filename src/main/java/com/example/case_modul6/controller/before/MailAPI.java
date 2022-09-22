package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.Enterprise;


import com.example.case_modul6.service.before.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/mail")
public class MailAPI {
    @Autowired
    SendMailService sendMailService;

    @PostMapping ("/send")
    public boolean send(@RequestBody Enterprise enterprise){
        return sendMailService.sendMail(enterprise.getGmailEnterprise(),"Xác nhân !", enterprise.getNameEnterprise()+"\nMã xác nhận của bạn là: ");
    }
    @GetMapping("/confirm")
    public String confirm(@RequestParam("code") String code){
        return sendMailService.confirmCode(code);
    }
    @GetMapping("/resetcode")
    public void resetcode(){
        sendMailService.rsCode();
    }
}
