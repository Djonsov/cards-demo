package com.example.cardsdemo.model;


import lombok.*;

/**
 * Класс описывает сущность "Банковская карта"
 */
@Getter
@Setter
public abstract class BankCard {

    private Double balance;

    public BankCard() {
        this.balance = 0d;
    }

    /**
     * Пополнить баланс
     * @param amount - количество вносимых на счет денежных средств
     */
    public abstract void addMoney(Double amount);

    /**
     * Оплатить покупку и списать денежные средства
     * @param amount - количество списываемых со счета денежных средств
     * @return - результат выполнения операции
     */
    public abstract Boolean pay(Double amount);

    /**
     * Получить информацию о балансе
     * @return - текущий баланс
     */
    public abstract Double balanceInfo();

    /**
     * Получить информацию о доступных средствах
     * @return - доступные средства
     */
    public abstract String availableMoneyInfo();

}
