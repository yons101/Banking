package com.yons101;

import com.yons101.exceptions.InsufficientFundsException;
import com.yons101.exceptions.InvalidAmountException;
import com.yons101.services.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BankingTest {
    private static final Logger logger = LogManager.getLogger(BankingTest.class);

    private static void runTest(String testName, Runnable testLogic) {
        logger.info("\nRunning Test: {}", testName);
        try {
            testLogic.run();
            // Only log PASS if the test logic completed without throwing an exception
            if (!testName.contains("Exception")) {
                logger.info("Result: PASS");
            }
        } catch (
                InsufficientFundsException |
                InvalidAmountException e) {
            logger.info("Result: PASS (Caught expected exception: {})", e.getMessage());
        } catch (Exception e) {
            logger.error("Result: FAIL (Caught unexpected exception: {} - {})",
                    e.getClass().getSimpleName(), e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Acceptance Scenario Test
        runTest("Acceptance Scenario", () -> {
            Account account = new Account();
            account.deposit(1000);
            account.deposit(2000);
            account.withdraw(500);
            account.printStatement();
        });

        // Withdrawal Exceeds Balance Test
        runTest("Withdrawal Exceeds Balance Exception", () -> {
            Account account = new Account();
            account.deposit(100);
            account.withdraw(200); // Throws InsufficientFundsException
        });

        // Deposit Invalid Amount Test
        runTest("Deposit Invalid Amount Exception", () -> {
            Account account = new Account();
            account.deposit(-10); // Throws InvalidAmountException
        });

        // Withdrawal Invalid Amount Test
        runTest("Withdrawal Invalid Amount Exception", () -> {
            Account account = new Account();
            account.deposit(500);
            account.withdraw(0);  // Throws InvalidAmountException
        });
    }
}
