package com.go2it.entities;

import java.util.Calendar;

public class CreditLine extends CreditProduct {
    private int limit;
    private double interest_rate;
    private Calendar updatedAt; //why in one class it is LocalDate type that describes the property and in other Calendar?

    public CreditLine(int limit, double interest_rate, int numDaysToPay) {
        this.limit = limit;
        this.interest_rate = interest_rate;
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
                ", updatedAt=" + updatedAt +
                '}';
    }
}
