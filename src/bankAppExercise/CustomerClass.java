package bankAppExercise;

public class CustomerClass {

    private String firstName;
    private String lastName;
    private Date DOB;
    private String customerAddress;
    private String accountNumber;
    private String BVN;
    private String accountType;

    Bank bank = new Bank();

    public CustomerClass(String firstName, String lastName, Date DOB, String customerAddress, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.accountNumber = bank.createAccountNumber();
        this.BVN = bank.createBvnNumber();
        this.customerAddress = customerAddress;
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "CustomerClass{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", customerAddress='" + customerAddress + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", BVN='" + BVN + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
