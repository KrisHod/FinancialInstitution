package com.go2it;

public class CreditLineService {

    public boolean applyForCreditLine(Customer customer) {
        if (customer.isResident() && customer.getCreditScore() > 700) {
            return true;
        } else {
            return false;
        }
    }
}
