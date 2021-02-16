package bankAppExercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    Customer customer;
    Account account;
    Bank bank;

    @BeforeEach
    void setUp() {
        user = new User();
        customer = new Customer();
        account = new Account();
        bank = new Bank();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void user_canSetAndGetFirstName(){
        user.SetFirstName("Toyin");
        assertEquals("Toyin", user.getFirstName());
    }

    @Test
    void user_canGetLastName(){
        user.setLastName("Onagoruwa");
        assertEquals("Onagoruwa", user.getLastName());
    }

    @Test
    void user_canSetAndGetAddress(){
        user.setAddress("42, Aderupoko street, iwaya");
        assertEquals("42, Aderupoko street, iwaya", user.getAddress());
    }

    @Test
    void user_canHavePhoneNumber(){
        user.setPhoneNumber("09086687275");
        assertEquals("09086687275", user.getPhoneNumber());
    }

    @Test
    void user_canSetDateOfBirth(){
        user.setDateOfBirth(13,3,1996);
        assertEquals("13/3/1996", user.displayDateOfBirth());
    }

    @Test
    void account_canHaveAccountID(){
        String accountID = account.generateAccountID();
        assertTrue(accountID.startsWith("OVT"));
        assertEquals(10,accountID.length());
        assertEquals(accountID, account.getAccountID());
    }

    @Test
    void account_canDeposit(){
        account.depositFunds(12000);
        assertEquals(12000, account.getAccountBalance());
    }

    @Test
    void account_canWithdraw(){
        account.depositFunds(15000);
        boolean thrown = false;
        try {
            account.withdrawFunds(15001.00);
        }catch(IllegalArgumentException e){
            thrown = true;
            System.out.println(e.getMessage());
        }
        assertTrue(thrown);
        assertEquals(15000, account.getAccountBalance());
    }

    @Test
    void customer_canBeAssignedANewAccountUponCreation(){
        Customer customer1 = new Customer("toyin", "onagoruwa", "42, Aderupoko street, iwaya - yaba", "09096687275", 13, 3, 1996, 123.2);
        System.out.println(customer1);
        assertNotNull(customer1);
    }

    @Test
    void bank_canStoreCustomerInformation(){
        Customer customerKunle = new Customer("Kunle", "Sandton", "12, Orunmila street, yaba","07038253061", 29, 12, 1980, 260.2);
        assertTrue(bank.addCustomer(customerKunle));
        System.out.println(bank);
    }

    @Test
    void customerAccountCanBeFetched(){
        Customer customerToyin = new Customer("toyin", "onagoruwa", "42, Aderupoko street, iwaya - yaba","09096687275", 13, 3, 1996, 123.2);
        Customer customerKunle = new Customer("Kunle", "Sandton", "12, Orunmila street, yaba","07038253061", 29, 12, 1980, 260.2);
        String kunleAcct = customerKunle.fetchAccountNumber(customerKunle);
        String toyinacct = customerToyin.fetchAccountNumber(customerToyin);
        System.out.println(kunleAcct);
        System.out.println(toyinacct);
        assertNotEquals(kunleAcct, toyinacct);
    }


}