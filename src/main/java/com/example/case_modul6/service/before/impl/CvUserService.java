package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.CvUser;
import com.example.case_modul6.repository.before.ICvUserRepo;
import com.example.case_modul6.service.before.InterfaceService.All.ICvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CvUserService implements ICvUserService {

    @Autowired
    ICvUserRepo cvUserRepo;
    @Override
    public void save(CvUser cvUser) {
        cvUserRepo.save(cvUser);
    }

    @Override
    public CvUser findByIdAppUser(int id) {
        return cvUserRepo.findCvByAppUser(id);
    }
}
