package com.example.cardsdemo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс описывает сущность "Дебетовая карта с программой кешбека"
 */
@Setter
@Getter
public final class CashbackDebitCard extends DebitCard {
    private static final Double cashBackMultiplier = 0.05;
    public CashbackDebitCard() {
        super();
    }

    /**
     * Списание со счета
     * @param amount - количество списываемых со счета денежных средств
     * @return - результат выполнения операции. True - успешное выполнение, false - неуспешное выполнение
     */
    @Override
    public Boolean pay(Double amount) {
        if (amount >= 5000)
            setBalance(getBalance() + amount * cashBackMultiplier);
        return super.pay(amount);
    }
}
