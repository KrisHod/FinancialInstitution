package com.go2it.entities;

public abstract class CreditProduct extends BankProduct {
    private double balance;
    private int limit;
    private double interestRate;

    public CreditProduct(Customer customer, double balance, int limit, double interestRate) {
        super(customer);
        this.balance = balance;
        this.limit = limit;
        this.interestRate = interestRate;
    }

    public CreditProduct(Customer customer, double balance, int limit) {
        super(customer);
        this.balance = balance;
        this.limit = limit;
    }

    public CreditProduct(Customer customer, double interestRate) {
        super(customer);
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "CreditProduct{" +
                "balance=" + balance +
                ", limit=" + limit +
                ", interestRate=" + interestRate +
                '}';
    }
}
