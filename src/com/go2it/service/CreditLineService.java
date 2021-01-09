package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;


public class CreditLineService extends CreditProductService {

    @Override
    public CreditLine applyCreditProduct(Customer customer) throws Exception {
        if (!isEligibleForCreditProduct(customer)) {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply mortgage");
        }
        long monthsOurClient = customer.getNumberMonthsOurClient();
        if (monthsOurClient < 24) {
            return new CreditLine(customer, 0, 2000, 22);
        } else if (monthsOurClient > 24 && monthsOurClient < 36) {
            return new CreditLine(customer, 0, 10000, 10);
        } else {
            return new CreditLine(customer, 0, 30000, 5);
        }
    }

    @Override
    public boolean isPromotionEligible(Customer customer) {
        return customer.getCreditScore() > 700;
    }

    @Override
    public void applyPromotion(BankProduct product) throws NotEligibleCustomerException {
        if (!(product instanceof CreditLine)) {
            throw new IllegalArgumentException("Incorrect type of banking product. Only Credit Line is allowed here");
        }
        CreditLine creditLine = (CreditLine) product;
        if (!isPromotionEligible(creditLine.getCustomer())) {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
        creditLine.setLimit(creditLine.getLimit() + 2000);
    }
}
