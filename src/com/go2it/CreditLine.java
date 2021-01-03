package com.go2it;

import java.time.Period;
import java.util.Calendar;

public class CreditLine {
    private int limit;
    private double interest_rate;
    private int numDaysToPay;
    private Calendar updatedAt;

    public CreditLine(int limit, double interest_rate, int numDaysToPay) {
        this.limit = limit;
        this.interest_rate = interest_rate;
        this.numDaysToPay = numDaysToPay;
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

    public int getNumDaysToPay() {
        return numDaysToPay;
    }

    public void setNumDaysToPay(int numDaysToPay) {
        this.numDaysToPay = numDaysToPay;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "CreditLine{" +
                "limit=" + limit +
                ", interest_rate=" + interest_rate +
                ", numDaysToPay=" + numDaysToPay +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
