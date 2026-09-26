import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
import model.annotation.Id;
import model.annotation.MaxLength;
import model.annotation.Positive;

public class BankAccount {

    @Id
    @MaxLength(10)
    private int accNo;

    private Customer owner;

    @Positive
    private long balance;

    public BankAccount(int accNo, Customer owner, long balance) {
        this.accNo = accNo;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public Customer getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than 0"
            );
        }

        balance = balance + amount;
    }

    public void withdraw(long amount)
            throws InsufficientFundsException, InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than 0"
            );
        }

        if (amount > balance) {

            long shortfall = amount - balance;

            throw new InsufficientFundsException(shortfall);
        }

        balance = balance - amount;
    }

    public void transfer(BankAccount to, long amount)
            throws BankException {

        try {

            withdraw(amount);
            to.deposit(amount);

        } catch (InvalidAmountException e) {

            throw new BankException(e.getMessage());

        } catch (InsufficientFundsException e) {

            throw new BankException(
                    "Transfer failed. Shortfall: "
                    + e.getShortfall()
            );

        } finally {

            System.out.println("Transfer operation completed.");
        }
    }

    @Override
    public String toString() {

        return "AccNo: " + accNo
                + " | Owner: " + owner.getName()
                + " | Balance: " + balance;
    }
}