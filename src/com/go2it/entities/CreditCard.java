package com.go2it.entities;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return that.getCustomer().equals(getCustomer()) && Double.compare(that.getBalance(), getBalance()) == 0
                && that.getLimit() == getLimit() && Double.compare(that.getAnnualFee(), getAnnualFee()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(),getBalance(), getLimit(), getAnnualFee());
    }

    @Override
    public String toString() {
        return "CreditCard of customer  - name ='" + getCustomer().getName() + '\'' +
                ", surname='" + getCustomer().getSurname() +
                ", balance=" + getBalance() +
                ", limit=" + getLimit() +
                ", annualFee=" + annualFee +
                '}';
    }
}
