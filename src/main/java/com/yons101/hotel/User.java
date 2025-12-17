package com.yons101.hotel;

import com.yons101.services.Account;

public class User {
    private int id;
    private Account account;

    public User(int id, int initialBalance) {
        this.id = id;
        this.account = new Account();
        this.account.deposit(initialBalance);
    }

    public int getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "User " + id;
    }
}
