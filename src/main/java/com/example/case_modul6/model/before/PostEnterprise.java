package com.example.case_modul6.model.before;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Entity
public class PostEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPostEnterprise;

    private String namePostEnterprise;

    private String addressMainEnterprise;

    private Time timePostEnterprise;

    private Date datePostEnterprise;

    private boolean statusPostEnterprise;

    private double salarySmallPostEnterprise;

    private double salaryBigPostEnterprise;
//  vị trí ứng tuyển
    private String vacanciesPostEnterprise;
//    hình thức job
    @ManyToOne
    private FormJob formJobPostEnterprise;
//    Ngày hết hạn
    private Date expirationDatePostEnterprise;
// độ ưu tiên bài đăng
    private int priorityPostEnterprise=0;

    private String describePostEnterprise;

    private int quantityApplyPost=0;
//    Chọn gói
    @ManyToOne
    private Regime regime;
// Lĩnh vực
    @ManyToOne
    private Field field;

    @ManyToOne
    private Enterprise enterprise;
//
//   @ManyToMany(fetch = FetchType.EAGER)
//    private List<CvUser> cvUsers;
}
