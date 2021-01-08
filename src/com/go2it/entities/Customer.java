package com.go2it.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Customer extends Person {
    private int spentLastMonth;
    private int creditScore;
    private boolean isResident;
    private boolean isStudent;
    private LocalDate dateBecomeCustomer;
    private Map<String, Person> familyMember = new HashMap<>();
    private Set<BankProduct> bankProducts = new HashSet<>();

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

    public Map<String, Person> getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(Map<String, Person> familyMember) {
        this.familyMember = familyMember;
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

    public Map<String,Person> addNewFamilyMember(String relationship, Person newFamilyMember) {
        familyMember.put(relationship, newFamilyMember);
        return familyMember;
    }

    public Set<BankProduct> getBankProducts() {
        return bankProducts;
    }

    public void setBankProducts(Set<BankProduct> bankProducts) {
        this.bankProducts = bankProducts;
    }

    /**
     * calculate how many months a person has been our customer
     */
    public long getNumberMonthsOurClient() {
        Period diff = Period.between(dateBecomeCustomer, LocalDate.now());
        return diff.toTotalMonths();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getName().equals(customer.getName()) && getSurname().equals(customer.getSurname()) && getDoB() == customer.getDoB() &&
                getSpentLastMonth() == customer.getSpentLastMonth() && getCreditScore() == customer.getCreditScore()
                && isResident() == customer.isResident() && isStudent() == customer.isStudent()
                && getDateBecomeCustomer().equals(customer.getDateBecomeCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getDoB(), getSpentLastMonth(),
                getCreditScore(), isResident(), isStudent(), getDateBecomeCustomer());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", DoB=" + getDoB() +
                ", spentLastMonth=" + spentLastMonth +
                ", creditScore=" + creditScore +
                ", isResident=" + isResident +
                ", isStudent=" + isStudent +
                ", dateBecomeCustomer=" + dateBecomeCustomer +
                ", bankProducts=" + bankProducts +
                '}';
    }
}
