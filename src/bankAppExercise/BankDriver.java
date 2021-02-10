package bankAppExercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDriver {

    public static void main(String[] args) {
        int userResponse;

        Scanner userInput = new Scanner(System.in);
        Bank bank = new Bank();

        System.out.println("=========================================================================================================");
        System.out.print("Welcome to OvisTee bankAppExercise.Bank. Below are the services offered by our distinguished institution:\n1. Open an Account\n2. Update your Account Details" +
                "\n3. Make a Deposit\n4. Make a Withdrawal\n5. Check your Account Balance\n6. Apply for a Loan\n7. Speak with a Customer Service Representative\nYour response here: ");
        userResponse = userInput.nextByte();

        if (userResponse > 6 || userResponse < 1) {
            throw new IllegalArgumentException("You entered an invalid option");
        }

        if (userResponse == 1) {
            System.out.print("You've made the right decision in choosing to bank with us. \nTo get you started, we only need you to fill in some basic details about yourself in the form below to get your account up and running. " +
                    "Do you wish to proceed? \n1. YES\n2. NO\nYour response here: ");
            userResponse = userInput.nextByte();

            System.out.print("Kindly enter your first name: ");
            String firstName = userInput.next();

            System.out.print("Kindly enter your last name: ");
            String lastName = userInput.next();

            System.out.print("Good job...now enter your date of birth at a time ie day->enter->month->year: ");
            int day = userInput.nextInt();
            int month = userInput.nextInt();
            int year = userInput.nextInt();

            if (day < 0 || day > 31 || month < 0 || month > 12 || year > 2003) {
                throw new InputMismatchException("You entered an invalid date");
            }

            System.out.println("Next, for your account type... type 1 for \"Savings\" or 2 for \"Current\": ");
            String accountType = userInput.next();
            userInput.nextLine();

            System.out.println("Splendid!...finally, enter your home address:");
            String address = userInput.nextLine();

            bank.createAccount(firstName, lastName, day, month, year, address, accountType);

            System.out.println("Congratulations! Your profile has been created successfully.\nHere are your account details:\n" + bank.getCustomer());

            System.out.println("Now that your account is all set up, what would you like to do next?\n1. Make a Transfer\n2. Deposit funds\n3. Go home");
            userResponse = userInput.nextInt();

            if (userResponse == 1) {
                System.out.println("You first need to deposit funds into your account to perform this action. To do this press 1 or press 2 to end program: ");
                userResponse = userInput.nextInt();

                if (userResponse == 1) {
                    System.out.println("How much would you like to deposit? ");
                    double value = userInput.nextDouble();

                    boolean result = bank.depositMoney(value);

                    if (result) {
                        System.out.println("Congratulations! you just deposited money into your account. Your new balance is: " + bank.getAccountBalance());
                    }

                    System.out.println("\nWhat would you like to do next?\n1. Make a withdrawal\n2. Apply for a loan\n3. Go home");
                    int reply = userInput.nextInt();

                    if (reply == 1) {
                        System.out.print("How much would you like to withdraw? ");
                        double withdrawAmount = userInput.nextDouble();

                        boolean output = bank.withdrawMoney(withdrawAmount);

                        if (output) {
                            System.out.println("Congratulations! You've successfully withdrawn " + withdrawAmount + ". Your new account balance is: " + bank.getAccountBalance());
                        }

                        System.out.println("Here are other actions you can perform:\n1. Apply for a loan\n2. Go home");
                        int customerResponse = userInput.nextInt();

                        if (customerResponse == 1) {
                            System.out.println("How much would you like to borrow? ");
                            double borrow = userInput.nextDouble();

                            boolean loanResult = bank.applyForLoan(bank.getAccountBalance(), borrow);

                            if (loanResult) {
                                System.out.println("Congratulations! Your loan application has been approved and your bank account has been credit accordingly." +
                                        " \nYour new account balance is: " + bank.getAccountBalance());
                            }

                            System.out.println("Do have a nice day...");
                        }
                    } else {
                        if (reply == 2) {
                            System.out.println("How much would you like to borrow? ");
                            double borrow = userInput.nextDouble();

                            boolean loanResult = bank.applyForLoan(bank.getAccountBalance(), borrow);

                            if (loanResult) {
                                System.out.println("Congratulations! Your loan application has been approved and your bank account has been credit accordingly." +
                                        " \nYour new account balance is: " + bank.getAccountBalance());
                            } else {
                                System.out.println("You are not eligible to borrow a loan at this time");
                            }

                            System.out.println("What would you like to do next?\n1. Go back to main menu\n2. Go home");
                            int userReply = userInput.nextInt();

                            if (userReply == 1) {
                                System.out.println("=========================================================================================================");
                                System.out.print("Welcome to OvisTee Bank. Below are the services offered by our distinguished institution:\n1. Open an Account\n2. Update your Account Details" +
                                        "\n3. Make a Deposit\n4. Make a Withdrawal\n5. Check your Account Balance\n6. Apply for a Loan\n7. Speak with a Customer Service Representative\nYour response here: ");
                                userResponse = userInput.nextByte();
                            } else {
                                System.out.println("Thanks for banking with us. Do have a nice day ahead.");
                            }
                        } else {
                            System.out.print("Thanks for banking with us. Do have a pleasant day ahead");
                        }
                    }
                } else {
                    System.out.print("Thanks for opening an account with us. Do have a pleasant day");
                }
            }
        }
    }
}
