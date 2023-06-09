package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Account;

import java.time.LocalDateTime;

public class AccountDTO {

    private long Id;

    private String number;
    private LocalDateTime creationDate;
    private double balance;


    public AccountDTO (Account account){

        this.Id = account.getId();
        this.number = account.getNumber();
        this.creationDate = account.getCreationDate();
        this.balance = account.getBalance();

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
