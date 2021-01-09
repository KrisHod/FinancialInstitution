package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountServiceTest {
    private Customer customer;
    private CheckingAccountService checkingAccountService;
    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        checkingAccountService = new CheckingAccountService();
        checkingAccount = new CheckingAccount(customer, 32098, 69);
        System.out.println("Finished Initialization");
        System.out.println();
    }

    @Test
    void TestIfPromotionEligible() {
        assertTrue(checkingAccountService.isPromotionEligible(customer));
    }

    @Test
    void TestIfPromotionEligibleNotEnoughSpentLastMonth() {
        customer.setSpentLastMonth(3000);
        assertFalse(checkingAccountService.isPromotionEligible(customer));
    }

    @Test
    void TestApplyPromotionIncorrectBankProduct() {
        try {
            BankProduct bankProduct = new CreditLine(customer, 30, 200, 3.5);
            checkingAccountService.applyPromotion(bankProduct);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    void TestApplyPromotionCustomerIsntEligible() {
        try {
            customer.setSpentLastMonth(4000);
            checkingAccountService.applyPromotion(checkingAccount);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }

    @Test
    void TestApplyPromotion() throws NotEligibleCustomerException {
        checkingAccountService.applyPromotion(checkingAccount);
        assertEquals(34.5, checkingAccount.getAnnualFee());
    }
}