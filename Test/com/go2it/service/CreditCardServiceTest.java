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

class CreditCardServiceTest {

    Customer customer;
    CreditCardService creditCardService;
    CreditCard creditCard;

    @BeforeEach
    void setUp() {
        customer = new Customer("John", "Petrov", LocalDate.of(1986, 2, 23), 6000, 560, true);
        creditCardService = new CreditCardService();
        creditCard = new CreditCard(customer, 0, 2000, 49);
        System.out.println("Finished Initialization");
        System.out.println();
    }

    @Test
    void TestApplyCreditProductCustomerIsntEligible() {
        try {
            customer.setResident(false);
            creditCardService.applyCreditProduct(customer);
        } catch (Exception e){
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }

    @Test
    void TestApplyCreditProductCreditScoreLess600 () throws Exception {
        customer.setCreditScore(500);
        assertEquals(new CreditCard(customer, 0, 2000, 99), creditCardService.applyCreditProduct(customer));
    }

    @Test
    void TestApplyCreditProductCreditScoreBetween600And700 () throws Exception {
        customer.setCreditScore(650);
        assertEquals(new CreditCard(customer, 0, 5000, 49), creditCardService.applyCreditProduct(customer));
    }

    @Test
    void TestApplyCreditProductCreditScoreMore700 () throws Exception {
        customer.setCreditScore(750);
        assertEquals(new CreditCard(customer, 0, 10000, 19), creditCardService.applyCreditProduct(customer));
    }

    @Test
    void TestIfPromotionEligible() {
        assertTrue(creditCardService.isPromotionEligible(customer));
    }

    @Test
    void TestIfPromotionEligibleCustomerIsntStudent() {
        customer.setStudent(false);
        assertFalse(creditCardService.isPromotionEligible(customer));
    }

    @Test
    void applyPromotion() throws NotEligibleCustomerException {
        customer.setStudent(true);
        creditCardService.applyPromotion(creditCard);
        assertEquals(0, creditCard.getAnnualFee());
    }

    @Test
    void TestApplyPromotionIncorrectBankProduct() {
        try {
            BankProduct bankProduct = new CreditLine(customer, 30, 200, 3.5);
            creditCardService.applyPromotion(bankProduct);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }
    }

    @Test
    void TestApplyPromotionCustomerIsntEligible() {
        try {
            customer.setStudent(false);
           creditCardService.applyPromotion(creditCard);
        } catch (Exception e) {
            assertEquals(e.getClass(), NotEligibleCustomerException.class);
        }
    }
}