package bankAppExercise;

import java.security.SecureRandom;

public class Account {
    private String accountID;
    private double accountBalance;

    StringBuilder stringBuilder = new StringBuilder();
    SecureRandom random;

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

    public void setAccountBalance(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("deposit amount cannot be less than $0");
        }
        this.accountBalance = amount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void depositFunds(int amount) {
        if (amount < 0){
            throw new IllegalArgumentException("Amount value cannot be less than $0");
        }
        this.accountBalance += amount;
    }

    public void withdrawFunds(int amount) {

        if (amount > accountBalance){
            throw new IllegalArgumentException("Withdrawal amount cannot be greater than account balance");
        }

        if (amount < 1){
            throw new IllegalArgumentException("Withdrawal amount cannot be less than $1");
        }

        this.accountBalance -= amount;
    }

    public void closeAccount(String accountID) {

    }

}
