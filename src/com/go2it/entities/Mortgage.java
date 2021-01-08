package com.go2it.entities;

import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mortgage)) return false;
        Mortgage mortgage = (Mortgage) o;
        return getCustomer().equals(mortgage.getCustomer()) && Double.compare(getInterestRate(), mortgage.getInterestRate()) == 0
                && getSum() == mortgage.getSum() && getNumMonths() == mortgage.getNumMonths()
                && getDateStart().equals(mortgage.getDateStart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getInterestRate(), getSum(), getNumMonths(), getDateStart());
    }

    @Override
    public String toString() {
        return "Mortgage of customer - - name ='" + getCustomer().getName() + '\'' +
                ", surname='" + getCustomer().getSurname() +
                ", sum=" + sum +
                ", numMonths=" + numMonths +
                ", interestRate=" + getInterestRate() +
                ", dateStart=" + dateStart +
                '}';
    }
}
