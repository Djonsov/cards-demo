package com.example.cardsdemo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс описывает сущность "Дебетовая карта с программой накопления"
 */
@Getter
@Setter
public final class SavingDebitCard extends DebitCard {
    private static final Double savingMultiplier = 0.005;
    private Double savings;

    public SavingDebitCard() {
        super();
        this.savings = 0.0;
    }

    /**
     * Пополнение счета.
     * @param amount - количество вносимых на счет денежных средств
     */
    @Override
    public void addMoney(Double amount) {
        savings += amount * savingMultiplier;
        super.addMoney(amount - amount * savingMultiplier);
    }

    /**
     * Получить информацию о доступных средствах
     * @return - доступные средства
     */
    @Override
    public String availableMoneyInfo() {
        return "Собственные средства: " + getBalance() + ".\nНакопления: " + savings;
    }
}
