package com.go2it.entities;

public class CreditCard extends CreditProduct {
    private double balance;
    private double annualFee;
    private int limit;

    public CreditCard(double balance, double annualFee, int limit) {
        this.balance = balance;
        this.annualFee = annualFee;
        this.limit = limit;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "balance=" + balance +
                ", annualFee=" + annualFee +
                ", limit=" + limit +
                '}';
    }
}
