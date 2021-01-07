package com.go2it.entities;

public class CheckingAccount extends BankProduct {
    private double balance;
    private double annualFee;


    public CheckingAccount(Customer customer, double balance, double annualFee) {
        super(customer);
        this.balance = balance;
        this.annualFee = annualFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }

}
