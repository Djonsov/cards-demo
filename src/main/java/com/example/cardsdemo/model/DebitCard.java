package com.example.cardsdemo.model;


import lombok.Getter;
import lombok.Setter;

/**
 * Класс описывает сущность "Дебетовая карта"
 */
@Getter
@Setter
public class DebitCard extends BankCard {
    public DebitCard() {
        super();
    }

    /**
     * Пополнение счета
     * @param amount - количество вносимых на счет денежных средств
     */
    @Override
    public void addMoney(Double amount) {
        setBalance(getBalance() + amount);
    }

    /**
     * Списание со счета
     * @param amount - количество списываемых со счета денежных средств
     * @return - результат выполнения операции. True - успешное выполнение, false - неуспешное выполнение
     */
    @Override
    public Boolean pay(Double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }

    /**
     * Получить информацию о балансе
     * @return - текущий баланс
     */
    @Override
    public Double balanceInfo() {
        return this.getBalance();
    }

    /**
     * Получить информацию о доступных средствах
     * @return - доступные средства
     */
    @Override
    public String availableMoneyInfo() {
        return "Собственные средства: " + getBalance();
    }
}
