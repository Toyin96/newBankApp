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
            int month =  userInput.nextInt();
            int year = userInput.nextInt();

            if (day < 0 || day > 31 || month < 0 || month > 12 || year > 2003){
                throw new InputMismatchException("You entered an invalid date");
            }

            System.out.println("Next, for your account type... type 1 for \"Savings\" or 2 for \"Current\": ");
             String accountType = userInput.nextLine();

            System.out.println("Splendid!...finally, enter your home address:");
            String address = userInput.nextLine();
            
            bank.createAccount(firstName, lastName, day, month, year, address, accountType);

            System.out.println("Congratulations! Your profile has been created successfully.\nHere are your account details:\n" + bank.getCustomer());
        }
    }
}
