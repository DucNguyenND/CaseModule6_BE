package com.example.case_modul6.service.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    JavaMailSender mailSender;
    String superCode="asj1hxnqj11$^&**()(*&^%$@!#$%^&*((*&^((*&^yhHJHVUHJK2";
    String code=superCode;
     String [] upper={ "A", "B", "C", "D", "E", "F", "G", "H", "I" ,"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
     String [] lower={"a", "b", "c", "d", "e", "f", "g", "h" ,"i" ,"k" , "l", "m", "n", "o","j", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
     int [] number={0,1,2,3,4,5,6,7,8,9};

     int size1=upper.length-1;
     int size2=number.length-1;
    public    int makeRandom(int min, int max){
        return  (int)((Math.random())*((max-min)+1)+min);
    }
    public  String createCode(){
        String newCode="";
        for (int i=0;i<8;i++){
            int from= makeRandom(1,3);
            switch (from){
                case 1:
                    newCode+=upper[makeRandom(0,size1)];
                    break;
                case 2:
                    newCode+=lower[makeRandom(0,size1)];
                    break;
                case 3:
                    newCode+=number[makeRandom(0,size2)];
                    break;
            }
        }
        code=newCode;
        return newCode;
    }

    public String createNumberVi(){
         String code ="";
         for(int i=0;i<8;i++){
              code +=makeRandom(0,size2);
         }
         return code;
    }

    public boolean sendMail(String toMail, String subject, String content){
        SimpleMailMessage message =new SimpleMailMessage();
//         chinh mail
        message.setFrom("ducnguyenbvtvc@gmail.com");
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(content);
//        Message message1=new MimeMessage();
        try {
            mailSender.send(message);
            return true;
        }catch (MailException mailException){
            System.out.println("loi roi"+mailException.getMessage());
            return false;
        }

    }

    public String confirmCode(String code1)
    {
        if (code1.equals(code)){
            rsCode();
            return "Xác nhận thành công";

        }else {
            return "Xác nhận thất bại";
        }
    }
    public void rsCode(){
        code=superCode;
    }

}
