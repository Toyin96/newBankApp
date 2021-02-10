package bankAppExercise;

public class Date {

    int month;
    int day;
    int year;

    public Date(int day, int month, int year) {

        this.month = month;
        this.day = day;
        this.year = year;

    }

    public String showDate(){
        return String.format("%d/%d/%d%n%n", day, month, year);
    }

    public String displayAccountCreationDate() {
        return String.format("Account created on: %d/%d/%d%n%n", day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }
}
