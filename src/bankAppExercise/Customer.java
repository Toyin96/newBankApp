package bankAppExercise;

public class Customer extends User{

    private Account account;
    private User customer;

    public Customer(String firstName, String lastName, String address, String phoneNumber, int day, int month, int year, Account account, User customer) {
        super(firstName, lastName, address, phoneNumber, day, month, year);
        this.account = account;
        this.customer = customer;
    }

    public Customer(){
    }

    public Account getAccount() {
        return account;
    }
}
