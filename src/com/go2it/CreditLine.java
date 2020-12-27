package com.go2it;

import java.time.Period;
import java.util.Calendar;

public class CreditLine {
    private int limit;
    private double interest_rate;
    private Period numDaysToPay;
    private Calendar updatedAt;

    public CreditLine(int limit, double interest_rate, Period numDaysToPay, Calendar updatedAt) {
        this.limit = limit;
        this.interest_rate = interest_rate;
        this.numDaysToPay = numDaysToPay;
        this.updatedAt = updatedAt;
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

    public Period getNumDaysToPay() {
        return numDaysToPay;
    }

    public void setNumDaysToPay(Period numDaysToPay) {
        this.numDaysToPay = numDaysToPay;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }
}
