package bankAppExercise;

public class User {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private int day;
    private int month;
    private int year;

    public User(String firstName, String lastName, String address, String phoneNumber, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public User() {
    }

    public void SetFirstName(String firstName) {
        this.firstName =firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {

        if (!(phoneNumber.length() == 11) && (!(phoneNumber.startsWith("+234"))) || phoneNumber.length() != 11){
            throw new IllegalArgumentException("You entered an invalid phone number details");
        }

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setDateOfBirth(int day, int month, int year) {

        if (day < 1 || day > 31 || month < 1 || month > 12 || year > 2020 || year < 1930){
            throw new IllegalArgumentException("The day/month or year you entered was out of range.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String displayDateOfBirth() {
        return String.format("%d/%d/%d", day, month, year);
    }

    @Override
    public String toString() {
        return String.format("NAME: " + firstName + "" + lastName + "\n"
               + "ADDRESS: " + address + "\n" + "PHONE NUMBER: " + phoneNumber + "\n" + "DATE OF BIRTH: %d/%d/%d", day,month,year
        );
    }
}
