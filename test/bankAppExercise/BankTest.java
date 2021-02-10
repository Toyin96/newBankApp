package bankAppExercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

        @Test
        void checkThatCustomerCanCreateAnAccount(){
            Bank bank = new Bank();
            bank.createAccount("Toyin", "Paul",12, 13, 1996,"42, Sabo street", "Savings");
            assertNotNull(bank.getCustomer());
        }

        @Test
        void customerHaveAccountNumberAndBvn(){
            Bank bank = new Bank();
            bank.updateAccount("BN", "ay", 12,3,2001, "Address", "savings");
            assertNotNull(bank.getCustomer());
        }

        @Test
        void checkThatAccountNumberCanBeGenerated(){
            Bank bank = new Bank();
            bank.createAccountNumber();
            String number = bank.getAccountNumber();
            assertTrue(number.startsWith("100"));
        }

        @Test
        void checkThatAccountBvnCanBeGenerated(){
            Bank bank = new Bank();
            bank.createBvnNumber();
            String bvn = bank.getBvnNumber();
            assertTrue(bvn.startsWith("BVN"));
        }

        @Test
        void checkThatCustomerCanDeposit() {
            Bank bank = new Bank();
            bank.depositMoney(500);
            double balance = bank.getAccountBalance();
            assertEquals(500, balance);
            boolean thrown = false;
            try {
                bank.depositMoney(-50);
            }catch(IllegalArgumentException e){
                thrown = true;
                System.out.println(e.getMessage());
            }
            assertTrue(thrown);
        }

        @Test
        void CheckThatCustomerCanWithdraw() {
            Bank bank = new Bank();
            bank.depositMoney(1000);
            try {  bank.withdrawMoney(1600);
            } catch(IllegalArgumentException e) {
                System.out.println(bank.getAccountBalance());
                System.out.println(e.getMessage());
            }
            double getBalance = bank.getAccountBalance();
            assertEquals(1000, getBalance);
        }

        @Test
        void checkThatCustomerCanApplyForAndGetALoanIfEligible(){
            Bank bank = new Bank();
            boolean result = bank.applyForLoan(120000, 50000);
            assertFalse(result);

            bank.depositMoney(45710);
            bank.depositMoney(75000);
            bank.depositMoney(19050);
            bank.depositMoney(85100);
            bank.withdrawMoney(15000);

            double acctBalance = bank.getAccountBalance();
            result = bank.applyForLoan(acctBalance, 50000);
            assertTrue(result);
        }

        @Test
        void checkThatNumberOfCustomerCanBeFetched(){
        Bank bank = new Bank();
        bank.fetchListOfCustomers();
        bank.createAccount("Toyin", "Onagoruwa", 13,3,1990, "32, sabo Street", "Savings");
        int list = bank.fetchListOfCustomers();
        assertEquals(1, list);
        }
}