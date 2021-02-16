package bankAppExercise;

public class Customer extends User{

    private Account account;

    public Customer(String firstName, String lastName, String address, String phoneNumber, int day, int month, int year, double openingBalance) {
        super(firstName, lastName, address, phoneNumber, day, month, year);
        this.account = new Account(openingBalance);
        //        Bank bank = new Bank();


    }

    public Customer(){
    }
    
    @Override
    public String toString() {
        return String.format("CUSTOMER PROFILE\n" + super.toString() + "\n" + account);
    }

    public String fetchAccountNumber(Customer customerName) {
       return customerName.account.getAccountID();
    }
}
