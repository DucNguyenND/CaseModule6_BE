package com.example.case_modul6.model.before;

public class FindPostByUser {
    private String nameEnterprise;
    private String city;
    private int idField;

    public FindPostByUser(String nameEnterprise, String city, int idField) {
        this.nameEnterprise = nameEnterprise;
        this.city = city;
        this.idField = idField;
    }

    public String getNameEnterprise() {
        return nameEnterprise;
    }

    public void setNameEnterprise(String nameEnterprise) {
        this.nameEnterprise = nameEnterprise;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getIdField() {
        return idField;
    }

    public void setIdField(int idField) {
        this.idField = idField;
    }
}
