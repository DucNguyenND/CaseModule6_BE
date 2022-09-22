package com.example.case_modul6.service.before.impl;

import com.example.case_modul6.model.before.Field;
import com.example.case_modul6.repository.before.IFieldRepo;
import com.example.case_modul6.service.before.InterfaceService.All.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FieldService implements IFieldService {
    @Autowired
    IFieldRepo fieldRepo;
    @Override
    public List<Field> findAll() {
       return (List<Field>) fieldRepo.findAll();
    }

    @Override
    public Field findById(int id) {
        return  fieldRepo.findById(id);
    }
}
