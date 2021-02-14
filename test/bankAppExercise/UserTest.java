package bankAppExercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    Customer customer;
    Account account;

    @BeforeEach
    void setUp() {
        user = new User();
        customer = new Customer();
        account = new Account();
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
    }

    @Test
    void account_canHaveAccountBalance(){
        account.setAccountBalance(11000);
        assertEquals(11000, account.getAccountBalance());
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
            account.withdrawFunds(15001);
        }catch(IllegalArgumentException e){
            thrown = true;
            System.out.println(e.getMessage());
        }
        assertTrue(thrown);
        assertEquals(15000, account.getAccountBalance());
    }

    @Test
    void account_canBeDeletedByCustomer(){
        account.closeAccount("OVT173208475");

    }

    @Test
    void customer_canBeAssignedANewAccountUponCreation(){
        customer.getAccount();
        System.out.println(customer.getAccount());
//        assertEquals();
    }
}