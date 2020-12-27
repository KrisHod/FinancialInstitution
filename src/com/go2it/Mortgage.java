package com.go2it;

import java.time.LocalDate;
import java.time.Period;

public class Mortgage {
    private int sum;
    private double interestRate;
    private int numMonths;
    private LocalDate dateStart;

    public Mortgage(int sum, double interestRate, int numMonths, LocalDate dateStart) {
        this.sum = sum;
        this.interestRate = interestRate;
        this.numMonths = numMonths;
        this.dateStart = dateStart;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getNumMonths() {
        return numMonths;
    }

    public void setNumMonths(int numMonths) {
        this.numMonths = numMonths;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }
}
