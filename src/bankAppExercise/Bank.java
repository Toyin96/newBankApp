package bankAppExercise;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        String acctNumber = customer.fetchAccountNumber(customer);
        for (int counter = 0; counter < customers.size(); counter++) {
            if (customers.get(counter).fetchAccountNumber(customer).equals(acctNumber)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "customers=" + customers +
                '}';
    }
}
