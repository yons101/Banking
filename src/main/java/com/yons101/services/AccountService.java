package com.yons101.services;

interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
