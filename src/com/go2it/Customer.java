package com.go2it;

import java.util.HashMap;

public class Customer {
    private String name;
    private int sumWasSpentLastMonth;
    private int creditScore;
    private boolean isResident;
    private HashMap<String, String> namesMemberFamily = new HashMap<String, String>();

    public Customer(String name, int sumWasSpentLastMonth, int creditScore, boolean isResident) {
        this.name = name;
        this.sumWasSpentLastMonth = sumWasSpentLastMonth;
        this.creditScore = creditScore;
        this.isResident = isResident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumWasSpentLastMonth() {
        return sumWasSpentLastMonth;
    }

    public void setSumWasSpentLastMonth(int sumWasSpentLastMonth) {
        this.sumWasSpentLastMonth = sumWasSpentLastMonth;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public HashMap<String, String> getNamesMemberFamily() {
        return namesMemberFamily;
    }

    public void setNamesMemberFamily(HashMap<String, String> namesMemberFamily) {
        this.namesMemberFamily = namesMemberFamily;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sumWasSpentLastMonth=" + sumWasSpentLastMonth +
                ", creditScore=" + creditScore +
                ", isResident=" + isResident +
                ", namesMemberFamily=" + namesMemberFamily +
                '}';
    }
}
