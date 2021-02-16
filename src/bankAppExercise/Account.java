package bankAppExercise;

import java.security.SecureRandom;

public class Account {
    private String accountID;
    private double accountBalance;

    StringBuilder stringBuilder = new StringBuilder();
    SecureRandom random;

    public Account(double accountBalance) {
        this.accountID = generateAccountID();
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public String generateAccountID() {
        String prefix = "OVT";
        accountID = stringBuilder.append(prefix).toString();
        random = new SecureRandom();

        for (int i = 0; i < 7; i++){
            int rand = 1 + random.nextInt(9);
            stringBuilder.append(rand);
        }
       this.accountID = stringBuilder.toString();
        return accountID;
    }

    public double getAccountBalance() {

        return accountBalance;
    }

    public void depositFunds(double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount value cannot be less than $0");
        }
       accountBalance += amount;
    }

    public void withdrawFunds(double amount) {

        if (amount > accountBalance){
            throw new IllegalArgumentException("Withdrawal amount cannot be greater than account balance");
        }

        if (amount < 1){
            throw new IllegalArgumentException("Withdrawal amount cannot be less than $1");
        }

        if (accountBalance < 1){
            throw new IllegalArgumentException("Insufficient funds! Deposit money first into your account before you can perform this operation.");
        }
        accountBalance -= amount;
    }

    @Override
    public String toString() {
        return String.format("AccountID: " + accountID + "\n" + "BALANCE: " + accountBalance);
    }

    public String getAccountID() {
        return accountID;
    }
}
