package com.go2it.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String name;
    private String surname;
    private LocalDate DoB;
    private int spentLastMonth;
    private int creditScore;
    private boolean isResident;
    private boolean isStudent;
    private LocalDate dateBecomeCustomer;
  //  private Mortgage mortgage;
 //   private CreditCard card;
    private Set<String> memberFamily = new HashSet<String>();

    public Customer(String name, int spentLastMonth, int creditScore, boolean isResident) {
        this.name = name;
        this.spentLastMonth = spentLastMonth;
        this.creditScore = creditScore;
        this.isResident = isResident;
    }

    public Customer(String name, int spentLastMonth, int creditScore, boolean isResident, CreditCard card) {
        this.name = name;
        this.spentLastMonth = spentLastMonth;
        this.creditScore = creditScore;
        this.isResident = isResident;

   //     this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<String> getMemberFamily() {
        return memberFamily;
    }

    public void setMemberFamily(Set<String> memberFamily) {
        this.memberFamily = memberFamily;    //what's about addNewFamilyMember()?
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate doB) {
        DoB = doB;
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

    //    public Mortgage getMortgage() {
//        return mortgage;
//    }
//
//    public void setMortgage(Mortgage mortgage) {
//        this.mortgage = mortgage;
//    }
//
//    public CreditCard getCard() {
//        return card;
//    }
//
//    public void setCard(CreditCard card) {
//        this.card = card;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", sumWasSpentLastMonth=" + spentLastMonth +
                ", creditScore=" + creditScore +
                ", isResident=" + isResident +
     //           ", mortgage=" + mortgage +
    //            ", card=" + card +
                ", namesMemberFamily=" + memberFamily +
                '}';
    }
}
