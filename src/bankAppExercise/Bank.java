package bankAppExercise;

import java.security.SecureRandom;

public class Bank {

    private String accountType;
    private String accountNumber;
    private CustomerClass customer;
    private String BVN;
    private double accountBalance;
    private double depositAmount;
    private double loan;
    private double withdrawalAmount;
    private Date date;
    private long debitCard;
    private int transactionHistory = 0;

    public void createAccount(String firstName, String lastName, int day, int month, int year, String address, String accountType) {
        Date date = new Date(day, month, year);
        this.date = date;
        createAccountNumber();
        createBvnNumber();
        this.customer = new CustomerClass(firstName,lastName,date, address, "Savings");
    }

    SecureRandom random = new SecureRandom();
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder stringBuilder1 = new StringBuilder();

    public CustomerClass getCustomer() {
        return customer;
    }

    public void updateAccount(String firstName, String lastName, int day, int month, int year, String address, String accountType) {
        Date date = new Date(day, month, year);
        this.date = date;
        this.customer = new CustomerClass(firstName,lastName,date, address,  accountType);
    }

    public String createAccountNumber() {
        String prefix = "100";
        stringBuilder.append(prefix);
        for (int i = 0; i < 7; i++){
            int rand = 1+ random.nextInt(9);
            stringBuilder.append(rand);
        }
        this.accountNumber = stringBuilder.toString();
        return stringBuilder.toString();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String createBvnNumber() {
        String prefix1 = "BVN";
        stringBuilder1.append(prefix1);

        for (int i = 1; i <= 4; i++){
            int rand = random.nextInt(9);
            stringBuilder1.append(rand);
        }
        this.BVN = stringBuilder1.toString();
        return stringBuilder1.toString();
    }

    public String getBvnNumber() {
    return BVN;
    }

    public void depositMoney(double depositAmount) {

        if (depositAmount < 0){
            throw new IllegalArgumentException("You entered an invalid amount");
        }
        accountBalance += depositAmount;
        transactionHistory++;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void withdrawMoney(double withdrawalAmount) {
        if (withdrawalAmount > accountBalance) {
            throw new IllegalArgumentException("You cannot withdraw an amount higher than your account balance");
        }
        accountBalance -= withdrawalAmount;
        transactionHistory++;
    }

    public boolean applyForLoan(double accountBalance, double loanAmount) {

        if (accountBalance > 100_000 && transactionHistory >= 5 && loanAmount <= (0.5 * accountBalance)){
            accountBalance += loanAmount;
            return true;
        }
        return false;
    }
}
