package com.go2it.entities;

public class CreditLine extends CreditProduct {

    private static final int WELCOMING_BONUS = 50;

    public CreditLine(Customer customer, double balance, int limit, double interestRate) {
        super(customer, balance, limit, interestRate);
    }

    public static int getWelcomingBonus() {
        return WELCOMING_BONUS;
    }

}
