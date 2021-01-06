package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.BankProduct;
import com.go2it.entities.CheckingAccount;
import com.go2it.entities.Customer;

public class CheckingAccountService extends BankProductService {

    @Override
    public boolean isPromotionEligible(Customer customer) {
        return customer.getSpentLastMonth() > CheckingAccount.getPromotionEligibleExpenses();
    }

    /**
     * if the customer is eligible to the promotion (is student), halve annual fee
     */
    @Override
    public void applyPromotion(Customer customer, BankProduct product) throws Exception {
        CheckingAccount checkingAccount = (CheckingAccount) product;

        if (isPromotionEligible(customer)) {
            checkingAccount.setAnnualFee(checkingAccount.getAnnualFee() / 2);
        } else {
            throw new NotEligibleCustomerException("Not eligible client attempts to apply promotion!");
        }
    }
}
