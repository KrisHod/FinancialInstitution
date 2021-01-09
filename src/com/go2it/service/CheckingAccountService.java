package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;

public class CheckingAccountService extends BankProductService {

    @Override
    public boolean isPromotionEligible(Customer customer) {
        return customer.getSpentLastMonth() > PROMOTION_ELIGIBLE_EXPENSES;
    }

    /**
     * if the customer is eligible to the promotion (is student), halve annual fee
     */
    @Override
    public void applyPromotion(BankProduct product) throws NotEligibleCustomerException {
        if (!(product instanceof CheckingAccount)) {
            throw new IllegalArgumentException("Incorrect type of banking product. Only Checking account is allowed here");
        }
        CheckingAccount checkingAccount = (CheckingAccount) product;

        if (!isPromotionEligible(checkingAccount.getCustomer())) {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
            checkingAccount.setAnnualFee(checkingAccount.getAnnualFee() / 2);
    }
}
