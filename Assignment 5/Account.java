package A5;
public class Account {

    protected int accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {

        if(amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");

        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Balance: " + balance);
    }

    public void displayAccount() {
        customer.displayCustomer();
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}