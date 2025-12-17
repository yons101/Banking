package com.yons101.services;

import com.yons101.data.Transaction;
import com.yons101.exceptions.InsufficientFundsException;
import com.yons101.exceptions.InvalidAmountException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private static final Logger logger = LogManager.getLogger(Account.class);

    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    private int txCounter = 0;
    private final String[] TEST_DATES = {"10/01/2012", "13/01/2012", "14/01/2012"};


    public int getBalance() {
        return balance;
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            logger.error("Deposit failed: Invalid amount {}", amount);
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        recordTransaction(amount);
        logger.info("Deposited: {}. New Balance: {}", amount, balance);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            logger.error("Withdrawal failed: Invalid amount {}", amount);
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            logger.warn("Withdrawal failed: Insufficient funds. Requested: {}, Available: {}", amount, balance);
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
        recordTransaction(-amount);
        logger.info("Withdrew: {}. New Balance: {}", amount, balance);
    }

    private void recordTransaction(int amount) {
        String date = TEST_DATES[txCounter++];
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");

        List<Transaction> printList = new ArrayList<>(transactions);
        Collections.reverse(printList);

        for (Transaction t : printList) {
            System.out.println(t.date() + " || " + t.amount() + " || " + t.balance());
        }
    }
}
