package com.example.case_modul6.model.before;

public class ChangePassWord {
    private String gmail;
    private String password;

    public ChangePassWord(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

