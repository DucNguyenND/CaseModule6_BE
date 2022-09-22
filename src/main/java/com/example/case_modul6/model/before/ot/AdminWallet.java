package com.example.case_modul6.model.before.ot;

public class AdminWallet {

    String passViAdmin;

    double numberMoney;

    public AdminWallet() {
    }

    public AdminWallet(String passViAdmin, double numberMoney) {
        this.passViAdmin = passViAdmin;
        this.numberMoney = numberMoney;
    }

    public String getPassViAdmin() {
        return passViAdmin;
    }

    public void setPassViAdmin(String passViAdmin) {
        this.passViAdmin = passViAdmin;
    }

    public double getNumberMoney() {
        return numberMoney;
    }

    public void setNumberMoney(double numberMoney) {
        this.numberMoney = numberMoney;
    }
}
