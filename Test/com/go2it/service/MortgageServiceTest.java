package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MortgageServiceTest {
    Customer customer;
    MortgageService mortgageService;
    Mortgage mortgage;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        mortgageService = new MortgageService();
        mortgage = new Mortgage(customer, 5.5, 20000, 120, LocalDate.now().plusDays(5));
        System.out.println("Finished Initialization");
        System.out.println();
    }

    @Test
    void TestApplyCreditProductCustomerIsntEligible() {
        try {
            customer.setResident(false);
            mortgageService.applyCreditProduct(customer);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }

    //TODO Test methods with Scanner
    @Test
    void TestApplyCreditProductCreditScoreLess600() throws Exception {
//        customer.setCreditScore(500);
//        Mortgage mortgage = mortgageService.applyCreditProduct(customer);
//        assertEquals(5.5 , mortgage.getInterestRate());
    }

    @Test
    void TestApplyCreditProductCreditScoreBetween600And700() throws Exception {

    }

    @Test
    void TestApplyCreditProductCreditScoreMore700() throws Exception {

    }


    @Test
    void TestIfPromotionEligible() {
        customer.setDateBecomeCustomer(LocalDate.of(2015, 4, 3));
        assertTrue(mortgageService.isPromotionEligible(customer));
    }

    @Test
    void TestIfPromotionIsntEligible() {
        customer.setDateBecomeCustomer(LocalDate.of(2020, 4, 3));
        assertFalse(mortgageService.isPromotionEligible(customer));
    }

    @Test
    void applyPromotion() throws NotEligibleCustomerException {
        customer.setDateBecomeCustomer(LocalDate.of(2015, 4, 3));
        mortgageService.applyPromotion(mortgage);
        assertEquals(5, mortgage.getInterestRate());
    }

    @Test
    void TestApplyPromotionIncorrectBankProduct() {
        try {
            BankProduct bankProduct = new CreditLine(customer, 30, 200, 3.5);
            mortgageService.applyPromotion(bankProduct);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    void TestApplyPromotionCustomerIsntEligible() {
        try {
            customer.setDateBecomeCustomer(LocalDate.of(2015, 4, 3));
            mortgageService.applyPromotion(mortgage);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }

    @Test
    void TestGetMonthlyPayment() {
        assertEquals(217.05255592095972, mortgageService.getMonthlyPayment(mortgage));
    }

    @Test
    void getTotalPayment() {
        assertEquals(26046.306710515168, mortgageService.getTotalPayment(mortgage));

    }

    ////No point to write
    @Test
    void getMonthlyPaymentCalendar() {
    }
}