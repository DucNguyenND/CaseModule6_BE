package com.example.case_modul6.service.before.InterfaceService.All;

import com.example.case_modul6.model.before.Field;

import java.util.List;

public interface IFieldService {

    List<Field> findAll();

    Field findById(int id);
}
