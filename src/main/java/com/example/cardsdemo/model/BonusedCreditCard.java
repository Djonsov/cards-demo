package com.example.cardsdemo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Класс описывает сущность "Кредитная карта с бонусной программой"
 */
@Getter
@Setter
public final class BonusedCreditCard extends CreditCard {
    private static final Double bonusMultiplier = 0.01;

    private Integer bonusPoints;

    public BonusedCreditCard() {
        super();
        this.bonusPoints = 0;
    }

    public BonusedCreditCard(Double creditLimit) {
        super(creditLimit);
        this.bonusPoints = 0;
    }

    public BonusedCreditCard(Integer bonusPoints) {
        super();
        this.bonusPoints = bonusPoints;
    }

    public BonusedCreditCard(Double creditLimit, Integer bonusPoints) {
        super(creditLimit);
        this.bonusPoints = bonusPoints;
    }

    /**
     * Списание со счета. В первую очередь списываются собственные средства. Также начисляются бонусные баллы.
     * @param amount - количество списываемых со счета денежных средств
     * @return - результат выполнения операции
     */
    @Override
    public Boolean pay(Double amount) {
        this.bonusPoints += (int) (amount * bonusMultiplier);
        return super.pay(amount);
    }

    /**
     * Получить информацию о доступных средствах
     * @return - доступные средства
     */
    @Override
    public String availableMoneyInfo() {
        return "Кредитные средства: " + getAvailableCredit() + ".\nСобственные средства: " + getBalance() + ".\nБонусные баллы: " + getBonusPoints() + ".";
    }
}
