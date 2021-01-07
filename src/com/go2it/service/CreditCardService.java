package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;

public class CreditCardService extends CreditProductService {
    /**
     * create a credit card according to the conditions
     */
    @Override
    public CreditCard applyCreditProduct(Customer customer) throws Exception {
        if (isEligibleForCreditProduct(customer)) {
            if (customer.getCreditScore() < 600) {
                return new CreditCard(customer, 0, 2000, 99);
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700) {
                return new CreditCard(customer, 0, 5000, 49);
            } else {
                return new CreditCard(customer, 0, 10000, 19);
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
    public void applyPromotion(BankProduct product) throws Exception {
        CreditCard creditCard = (CreditCard) product;

        if (isPromotionEligible(creditCard.getCustomer())) {
            creditCard.setAnnualFee(0);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }
}
