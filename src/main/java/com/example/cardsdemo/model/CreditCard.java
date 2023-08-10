package com.example.cardsdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Класс описывает сущность "Кредитная карта"
 */
@Getter
@Setter
public class CreditCard extends BankCard {

    private final Double creditLimit;

    private Double availableCredit;

    public CreditCard() {
        super();
        this.creditLimit = 10000.0;
        this.availableCredit = this.creditLimit;
    }

    public CreditCard(Double creditLimit) {
        super();
        this.creditLimit = creditLimit;
        this.availableCredit = this.creditLimit;
    }

    /**
     * Пополнение счета. В первую очередь гасится кредитная часть.
     * @param amount - количество вносимых на счет денежных средств
     */
    @Override
    public void addMoney(Double amount) {
        if (creditLimit - availableCredit > amount) {
            availableCredit += amount;
        } else if (creditLimit.equals(availableCredit)) {
            setBalance(getBalance() + amount);

        } else {
            double delta = creditLimit - availableCredit;
            availableCredit += delta;
            setBalance(getBalance() + delta);
        }
    }

    /**
     * Списание со счета. В первую очередь списываются собственные средства.
     * @param amount - количество списываемых со счета денежных средств
     * @return
     */
    @Override
    public Boolean pay(Double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        } else if (availableCredit > 0 ) {
            double delta = amount - getBalance();
            setBalance(0.0);
            availableCredit -= delta;
            return true;
        } else
            return false;
    }

    /**
     * Получить информацию о балансе
     * @return - текущий баланс
     */
    @Override
    public Double balanceInfo() {
        return getBalance();
    }

    /**
     * Получить информацию о доступных средствах
     * @return - доступные средства
     */
    @Override
    public String availableMoneyInfo() {
        return "Кредитные средства: " + getAvailableCredit() + ".\nСобственные средства: " + getBalance() + ".";
    }
}
