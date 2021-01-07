package com.go2it.entities;

import java.time.LocalDate;

public class Mortgage extends CreditProduct {
    private int sum;
    private int numMonths;
    private LocalDate dateStart;

    public Mortgage(Customer customer, double interestRate, int sum, int numMonths, LocalDate dateStart) {
        super(customer, interestRate);
        this.sum = sum;
        this.numMonths = numMonths;
        this.dateStart = dateStart;
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

    public LocalDate calculateEndDate() {
        return dateStart.plusMonths(numMonths);
    }

    @Override
    public String toString() {
        return "Mortgage{" +
                "sum=" + sum +
                ", numMonths=" + numMonths +
                ", dateStart=" + dateStart +
                '}';
    }
}
