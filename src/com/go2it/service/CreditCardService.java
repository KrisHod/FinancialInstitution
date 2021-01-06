package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;

import java.time.LocalDate;


public class CreditCardService extends CreditProductService {
    /**
     * create a credit card according to the conditions
     */
    @Override
    public CreditCard applyCreditProduct(Customer customer) throws Exception {
        if (isEligibleForCreditProduct(customer)) {
            if (customer.getCreditScore() < 600) {
                return new CreditCard(0, 99, 2000);
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700) {
                return new CreditCard(0, 49, 5000);
            } else {
                return new CreditCard(0, 19, 10000);
            }
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply mortgage");
        }
    }

    @Override
    public boolean isPromotionEligible(Customer customer) {
        return customer.isStudent();
    }

    @Override
    public void applyPromotion(Customer customer, BankProduct product) throws Exception {
        CreditCard creditCard = (CreditCard) product;

        if (isPromotionEligible(customer)) {
            creditCard.setAnnualFee(0);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }
}
