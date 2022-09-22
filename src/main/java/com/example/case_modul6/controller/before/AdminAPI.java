package com.example.case_modul6.controller.before;

import com.example.case_modul6.model.before.*;
import com.example.case_modul6.model.before.ot.AdminWallet;
import com.example.case_modul6.service.before.InterfaceService.All.*;

import com.example.case_modul6.service.before.SendMailService;

import com.example.case_modul6.service.before.impl.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    SendMailService sendMailService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    ITransactionHistoryService transactionHistoryService;

    @Autowired
    ITransactionWalletService transactionWalletService;

    @Autowired
    IViAdminService viAdminService;

    @Autowired
    ITransWalletHrService transWalletHrService;
    @GetMapping("/getAllNotConfirm")
    public ResponseEntity<List<Enterprise>> getAllEnterpriseNotConfirm() {
        return new ResponseEntity<>(enterpriseService.getAllEnterpriseNotConfirmOrderByTime(), HttpStatus.OK);
    }

    @GetMapping("/getAllConfirm")
    public ResponseEntity<List<Enterprise>> getAllEnterpriseConfirm() {
        return new ResponseEntity<>(enterpriseService.listEnterpriseOderByRates(), HttpStatus.OK);
    }

    @GetMapping("/findEnterprise/{id}")
    public ResponseEntity<Enterprise> findById(@PathVariable int id) {
        return new ResponseEntity<>(enterpriseService.findEnterpriseById(id), HttpStatus.OK);
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<Enterprise> confirmEnterprise(@PathVariable int id) {
        String password = sendMailService.createCode();
        String codeVi = sendMailService.createCode();
        String numberVi = sendMailService.createNumberVi();
        String mail = enterpriseService.findEnterpriseById(id).getGmailEnterprise();
        sendMailService.sendMail(mail, "Thông tin xác thực", "Việc làm  24 đã xác thực yêu cầu của bạn :\n\t\t-Số ví :" + numberVi + "\n\t\t- Mã ví điện tử  :" + codeVi + "\n\t\t- Mật khẩu :" + password + "\nLưu ý  :" +
                "\n\t\t\t - Để bảo mật đổi mật khẩu ứng dụng trước khi sử dụng ! \n\t\t\t- Để hoạt động trước tiên vui lòng nạp tiền vào ví điện tử !\n\t Xin cảm ơn !");
        enterpriseService.confirmRegisterEnterprise(password, codeVi, numberVi, 1, id);
        AppUser appUser = new AppUser();
        appUser.setUsername(enterpriseService.findEnterpriseById(id).getGmailEnterprise());
//        Chỉnh sửa password
        appUser.setPassword(password);
        appUser.setEmail(enterpriseService.findEnterpriseById(id).getGmailEnterprise());
        Role role = new Role();
        role.setId(2);
        appUser.setRoles(role);
        appUserService.save(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/refuseConfirm/{id}/{reasonRefuse}")
    public ResponseEntity<Enterprise> refuseConfirmEnterprise(@PathVariable int id, @PathVariable String reasonRefuse) {
        String mail = enterpriseService.findEnterpriseById(id).getGmailEnterprise();
        sendMailService.sendMail(mail, "Thông báo ", "Việc làm  24 thông báo :\n\t\t\t Công ty của bạn không đủ điều kiện để chúng tôi xác thực !\n\t\t\tLý do : " + reasonRefuse + "\n\t\tXin cảm ơn !");
        enterpriseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listTransactionHistory")
    public ResponseEntity<List<TransactionHistory>> listTransactionHistory() {
        return new ResponseEntity<>(transactionHistoryService.listTransactionHistory(), HttpStatus.OK);
    }

    @GetMapping("/listEnterpriseOderByRates")
    public ResponseEntity<List<Enterprise>> listEnterpriseOderByRates() {
        return new ResponseEntity<>(enterpriseService.listEnterpriseOderByRates(), HttpStatus.OK);
    }

    @GetMapping("/totalTransaction")
    public ResponseEntity<Integer> totalTransaction() {
        return new ResponseEntity<>(transactionHistoryService.totalTransaction(), HttpStatus.OK);
    }

    @GetMapping("/listTransactionHistoryByDateNow")
    public ResponseEntity<List<TransactionHistory>> listTransactionHistoryByDateNow() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String dateStr = "'" + date + "'";
        return new ResponseEntity<>(transactionHistoryService.listTransactionHistoryByDateNow(dateStr), HttpStatus.OK);
    }
// khóa doanh nghiệp
    @GetMapping("/setStatusEnterpriseTo1/{id}")
    public ResponseEntity<Enterprise> setStatusEnterpriseTo1(@PathVariable int id) {
        enterpriseService.setStatusEnterpriseTo1(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/setStatusEnterpriseTo0/{id}")
    public ResponseEntity<Enterprise> setStatusEnterpriseTo0 ( @PathVariable int id){
        enterpriseService.setStatusEnterpriseTo0(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    //    Hiện thị danh sách giao dịch nạp tiền !
    @GetMapping("transWalletAll")
    public ResponseEntity<List<TransactionWallet>> getAllTransWallet(){
         return  new ResponseEntity<>(transactionWalletService.transactionWalletAll(),HttpStatus.OK);
    }
    @GetMapping("/getViAdmin")
    public ResponseEntity<ViAdmin> getViAdmin(){
        return new ResponseEntity<>(viAdminService.getViAdmin(),HttpStatus.OK);
    }
    @GetMapping("getTransWalletById/{id}")
    public ResponseEntity<TransactionWallet> getTransWalletById(@PathVariable int id){
        return new ResponseEntity<>(transactionWalletService.transactionById(id),HttpStatus.OK);
    }
    @PostMapping ("/confirmTransWallet/{id}")
    public ResponseEntity<Integer>confirmTransWallet(@PathVariable int id){
        int percentDiscount;
        double moneyToEnterprise;
        double moneyDiscountAfter;
        TransWalletHr transWalletHr;
        double moneyDiscount;
        Time timeNow = Time.valueOf(java.time.LocalTime.now());
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        int idEnterprise = transactionWalletService.transactionById(id).getEnterprise().getIdEnterprise();
        Enterprise enterpriseTrans = enterpriseService.findEnterpriseById(idEnterprise);
        ViAdmin viAdmin = viAdminService.getViAdmin();
        double moneyViEnterprise = enterpriseService.getMoneyViEnterpriseById(idEnterprise);
        double moneyTrans= transactionWalletService.transactionById(id).getNumberMoney();
        double moneyViAdmin = viAdminService.getViAdmin().getNumberMoneyVi();
        double moneyViAdminExits;
        if(moneyViAdmin>moneyTrans){
              percentDiscount = viAdminService.percentDiscount(moneyTrans);
              moneyDiscount = (percentDiscount* moneyTrans)/100;
             moneyDiscountAfter = moneyTrans - moneyDiscount;
             moneyToEnterprise = moneyViEnterprise+ moneyDiscountAfter;
             moneyViAdminExits = moneyViAdmin -moneyDiscountAfter;
             enterpriseService.setViEnterprise(idEnterprise,moneyToEnterprise);
             viAdminService.setMoneyViAdmin(moneyViAdminExits);
             transWalletHr = new TransWalletHr(viAdmin,enterpriseTrans,moneyTrans,moneyDiscountAfter,moneyDiscount,date,timeNow);
              transWalletHrService.save(transWalletHr);
             transactionWalletService.setStatusConfirmTransWallet(id);
             return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/walletAdmin")
    public ResponseEntity<Double> walletAdmin(@RequestBody AdminWallet adminWallet){
         if(adminWallet.getPassViAdmin().equals(viAdminService.getPassViAdmin())){
               double moneyIng = viAdminService.getMoneyViAdmin();
               double money = moneyIng+adminWallet.getNumberMoney();
               viAdminService.setMoneyViAdmin(money);
               return new ResponseEntity<>(HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/transWalletHrAll")
    public  ResponseEntity<List<TransWalletHr>> getTransWalletHrAll(){
           return new ResponseEntity<>(transWalletHrService.findAllTransWalletHr(),HttpStatus.OK);
    }
    @GetMapping("/transWalletHrAllDateNow")
    public ResponseEntity<List<TransWalletHr>> getTransWalletHrAllDateNow(){
        return new ResponseEntity<>(transWalletHrService.getAllTransWalletDateNow(),HttpStatus.OK);
    }
    @GetMapping("/totalMoneyTransDateNow")
    public ResponseEntity<Double> totalMoneyTransDateNow(){
        return new ResponseEntity<>(transWalletHrService.totalMoneyTransDateNow(),HttpStatus.OK);
    }
}





