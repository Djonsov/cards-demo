package com.example.cardsdemo;


import com.example.cardsdemo.model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CardTest {
    @Test
    @Order(1)
    public void debitCardTest(){
        DebitCard card = new DebitCard();
        assertEquals(card.balanceInfo(), 0d);
        card.addMoney(5000d);
        assertEquals(card.balanceInfo(), 5000d);
        card.pay(2000d);
        assertEquals(card.balanceInfo(), 3000d);
    }

    @Test
    @Order(2)
    public void CashbackDebitCardTest(){
        CashbackDebitCard card = new CashbackDebitCard();
        card.addMoney(50000d);
        assertEquals(card.balanceInfo(), 50000d);
        card.pay(10000d);
        assertEquals(card.balanceInfo(), 40500d);
    }

    @Test
    @Order(3)
    public void savingDebitCardTest(){
        SavingDebitCard card = new SavingDebitCard();
        card.addMoney(10000d);
        assertEquals(card.getSavings(),50d);
    }
    @Test
    @Order(4)
    public void creditCardTest(){
        CreditCard card = new CreditCard();
        assertEquals(card.getCreditLimit(), 10000d);
        assertEquals(card.balanceInfo(), 0d);
        card.addMoney(5000d);
        assertEquals(card.balanceInfo(), 5000d);
        card.pay(5000d);
        assertEquals(card.balanceInfo(), 0d);
        card.pay(3000d);
        assertEquals(card.balanceInfo(), 0d);
        assertEquals(card.getAvailableCredit(), 7000d);
        card.addMoney(2000d);
        assertEquals(card.balanceInfo(), 0d);
        assertEquals(card.getAvailableCredit(), 9000d);
        card.addMoney(2000d);
        assertEquals(card.balanceInfo(), 1000d);
        assertEquals(card.getAvailableCredit(), 10000d);
    }

    @Test
    @Order(5)
    public void bonusedCreditCardTest(){
        BonusedCreditCard card = new BonusedCreditCard();
        card.pay(1000d);
        assertEquals(card.getBonusPoints(),10);
    }

}
