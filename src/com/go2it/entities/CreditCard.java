package com.go2it.entities;

public class CreditCard extends CreditProduct {
    private double annualFee;

    public CreditCard(Customer customer, double balance, int limit, double annualFee) {
        super(customer, balance, limit);
        this.annualFee = annualFee;
    }

    public double getAnnualFee() {
        return annualFee;
    }

    public void setAnnualFee(double annualFee) {
        this.annualFee = annualFee;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "annualFee=" + annualFee +
                '}';
    }
}
