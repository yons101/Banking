

com.yons101.BankingTest - 
Running Test: Acceptance Scenario

com.yons101.services.Account - Deposited: 1000. New Balance: 1000

com.yons101.services.Account - Deposited: 2000. New Balance: 3000

com.yons101.services.Account - Withdrew: 500. New Balance: 2500

Date || Amount || Balance
14/01/2012 || -500 || 2500
13/01/2012 || 2000 || 3000
10/01/2012 || 1000 || 1000

com.yons101.BankingTest - Result: PASS

com.yons101.BankingTest - 
Running Test: Withdrawal Exceeds Balance Exception

com.yons101.services.Account - Deposited: 100. New Balance: 100

com.yons101.services.Account - Withdrawal failed: Insufficient funds. Requested: 200, Available: 100

com.yons101.BankingTest - Result: PASS (Caught expected exception: Insufficient funds for withdrawal)

com.yons101.BankingTest - 
Running Test: Deposit Invalid Amount Exception

com.yons101.services.Account - Deposit failed: Invalid amount -10

com.yons101.BankingTest - Result: PASS (Caught expected exception: Deposit amount must be positive)

com.yons101.BankingTest - 
Running Test: Withdrawal Invalid Amount Exception

com.yons101.services.Account - Deposited: 500. New Balance: 500

com.yons101.services.Account - Withdrawal failed: Invalid amount 0

com.yons101.BankingTest - Result: PASS (Caught expected exception: Withdrawal amount must be positive)
