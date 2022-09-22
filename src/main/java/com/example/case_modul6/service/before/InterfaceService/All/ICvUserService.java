package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.CvUser;

public interface ICvUserService {

    void save(CvUser cvUser);

    CvUser findByIdAppUser(int id);
}
