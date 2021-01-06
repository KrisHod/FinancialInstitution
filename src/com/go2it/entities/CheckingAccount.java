package com.go2it.entities;

public class CheckingAccount extends BankProduct{
    private double balance;
    private double annualFee;

    private static final int PROMOTION_ELIGIBLE_EXPENSES = 5000;

    public CheckingAccount(double balance, double annualFee) {
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

    public static int getPromotionEligibleExpenses() {
        return PROMOTION_ELIGIBLE_EXPENSES;
    }
}
