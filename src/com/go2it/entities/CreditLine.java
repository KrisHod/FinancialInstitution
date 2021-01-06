package com.go2it.entities;

import java.time.LocalDate;
import java.util.Calendar;

public class CreditLine extends CreditProduct {
    private double balance;
    private int limit;
    private double interest_rate;

    private static final int WELCOMING_BONUS = 50;

    public CreditLine(double balance, int limit, double interest_rate) {
        this.balance =+ WELCOMING_BONUS;
        this.limit = limit;
        this.interest_rate = interest_rate;
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

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public static int getWelcomingBonus() {
        return WELCOMING_BONUS;
    }

    @Override
    public String toString() {
        return "CreditLine{" +
                "balance=" + balance +
                ", limit=" + limit +
                ", interest_rate=" + interest_rate +
                '}';
    }
}
