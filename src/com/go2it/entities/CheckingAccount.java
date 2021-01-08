package com.go2it.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount)) return false;
        CheckingAccount that = (CheckingAccount) o;
        return that.getCustomer().equals(getCustomer()) && Double.compare(that.getBalance(), getBalance()) == 0
                && Double.compare(that.getAnnualFee(), getAnnualFee()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBalance(), getAnnualFee(), getCustomer());
    }

    @Override
    public String toString() {
        return "CheckingAccount of customer - name='" + getCustomer().getName() + '\'' +
                ", surname='" + getCustomer().getSurname() +
                ", balance=" + balance +
                ", annualFee=" + annualFee +
                '}';
    }
}
