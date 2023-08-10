package com.example.cardsdemo;

import com.example.cardsdemo.model.CashbackDebitCard;
import com.example.cardsdemo.model.CreditCard;
import com.example.cardsdemo.model.DebitCard;
import com.example.cardsdemo.model.SavingDebitCard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CardsDemoApplication.class, args);
    }
}
