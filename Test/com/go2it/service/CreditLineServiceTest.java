package com.go2it.service;

import com.go2it.NotEligibleCustomerException;
import com.go2it.entities.BankProduct;
import com.go2it.entities.CreditCard;
import com.go2it.entities.CreditLine;
import com.go2it.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CreditLineServiceTest {
    Customer customer;
    CreditLineService creditLineService;
    CreditLine creditLine;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        customer.setDateBecomeCustomer(LocalDate.of(2010, 3, 21));
        creditLineService = new CreditLineService();
        System.out.println("Finished Initialization");
        System.out.println();
    }

    @Test
    void TestApplyCreditProductCustomerIsntEligible() {
        try {
            customer.setCreditScore(300);
            creditLineService.applyCreditProduct(customer);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }

    @Test
    void TestApplyCreditProductMonthsOurClientLess24() throws Exception {
        customer.setDateBecomeCustomer(LocalDate.of(2020, 12, 1));
        CreditLine creditLine = creditLineService.applyCreditProduct(customer);
        assertEquals(2000, creditLine.getLimit());
    }

    @Test
    void TestApplyCreditProductMonthsOurClientBetween24And36() throws Exception {
        customer.setDateBecomeCustomer(LocalDate.of(2018, 5, 1));
        CreditLine creditLine = creditLineService.applyCreditProduct(customer);
        assertEquals(10000, creditLine.getLimit());
    }

    @Test
    void TestApplyCreditProductMonthsOurClientMore36() throws Exception {
        customer.setDateBecomeCustomer(LocalDate.of(2010, 5, 1));
        CreditLine creditLine = creditLineService.applyCreditProduct(customer);
        assertEquals(30000, creditLine.getLimit());
    }

    @Test
    void TestIfPromotionEligible() {
        customer.setCreditScore(750);
        assertTrue(creditLineService.isPromotionEligible(customer));
    }

    @Test
    void TestIfPromotionEligibleCreditScoreLess700() {
        assertFalse(creditLineService.isPromotionEligible(customer));
    }

    @Test
    void applyPromotion() throws NotEligibleCustomerException {
        customer.setCreditScore(750);
        creditLine = new CreditLine(customer, 0, 10000, 10);
        creditLineService.applyPromotion(creditLine);
        assertEquals(12000, creditLine.getLimit());
    }

    @Test
    void TestApplyPromotionIncorrectBankProduct() {
        try {
            BankProduct bankProduct = new CreditCard(customer, 30, 200, 99);
            creditLineService.applyPromotion(bankProduct);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    void TestApplyPromotionCustomerIsntEligible() {
        try {
            creditLine = new CreditLine(customer, 0, 10000, 10);
            creditLineService.applyPromotion(creditLine);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }
}