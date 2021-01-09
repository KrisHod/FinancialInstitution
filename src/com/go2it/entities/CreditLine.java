package com.go2it.entities;

import java.util.Objects;

public class CreditLine extends CreditProduct {

    private static final int WELCOMING_BONUS = 50;

    public CreditLine(Customer customer, double balance, int limit, double interestRate) {
        super(customer, balance, limit, interestRate);
    }

    public static int getWelcomingBonus() {
        return WELCOMING_BONUS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return that.getCustomer().equals(getCustomer()) && Double.compare(that.getBalance(), getBalance()) == 0
                && that.getLimit() == getLimit() && Double.compare(that.getInterestRate(), getInterestRate()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(),getBalance(), getLimit(), getInterestRate());
    }

    @Override
    public String toString() {
        return "Credit Line of customer  - name ='" + getCustomer().getName() + '\'' +
                ", surname='" + getCustomer().getSurname() +
                ", balance=" + getBalance() +
                ", limit=" + getLimit() +
                ", interestRate=" + getInterestRate() +
                '}';
    }

}
