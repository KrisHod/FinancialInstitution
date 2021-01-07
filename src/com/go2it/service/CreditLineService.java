package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;


public class CreditLineService extends CreditProductService {

    @Override
    public CreditLine applyCreditProduct(Customer customer) throws Exception {
        long monthsOurClient = customer.getNumberMonthsOurClient();
        if (isEligibleForCreditProduct(customer)) {
            if (customer.getCreditScore() < 600 && monthsOurClient < 24) {
                return new CreditLine(customer, 0, 2000, 22);
            } else if (customer.getCreditScore() >= 600 && customer.getCreditScore() < 700 && monthsOurClient > 24) {
                return new CreditLine(customer, 0, 10000, 10);
            } else {
                return new CreditLine(customer, 0, 30000, 5);
            }
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply mortgage");
        }
    }

    @Override
    public boolean isPromotionEligible(Customer customer) {
        return customer.getCreditScore() > 700;
    }

    @Override
    public void applyPromotion(BankProduct product) throws Exception {
        CreditLine creditLine = (CreditLine) product;

        if (isPromotionEligible(creditLine.getCustomer())) {
            creditLine.setLimit(creditLine.getLimit() + 2000);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }
}
