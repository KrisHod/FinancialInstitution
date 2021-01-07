package com.go2it.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class Customer extends Person {
    private int spentLastMonth;
    private int creditScore;
    private boolean isResident;
    private boolean isStudent;
    private LocalDate dateBecomeCustomer;
    private Set<Person> memberFamily = new HashSet<>();

    public Customer(String name, String surname, LocalDate doB, int spentLastMonth, int creditScore, boolean isResident) {
        super(name, surname, doB);
        this.spentLastMonth = spentLastMonth;
        this.creditScore = creditScore;
        this.isResident = isResident;
    }

    public int getSpentLastMonth() {
        return spentLastMonth;
    }

    public void setSpentLastMonth(int spentLastMonth) {
        this.spentLastMonth = spentLastMonth;
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

    public Set<Person> getMemberFamily() {
        return memberFamily;
    }

    public void setMemberFamily(Set<Person> memberFamily) {
        this.memberFamily = memberFamily;    //what's about addNewFamilyMember()?
    }

    public LocalDate getDateBecomeCustomer() {
        return dateBecomeCustomer;
    }

    public void setDateBecomeCustomer(LocalDate dateBecomeCustomer) {
        this.dateBecomeCustomer = dateBecomeCustomer;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    /**
     * calculate how many months a person has been our customer
     */
    public long getNumberMonthsOurClient() {
        Period diff = Period.between(dateBecomeCustomer, LocalDate.now());
        return diff.toTotalMonths();
    }
}
