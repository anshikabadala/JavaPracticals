import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankApp {

    static ArrayList<BankAccount> accountList = new ArrayList<>();
    static ArrayList<Customer> customerList = new ArrayList<>();
    static ArrayList<String> logList = new ArrayList<>();
    static int nextAccNo = 1001;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== SIMPLE BANK SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Show All Accounts");
            System.out.println("7. Search Account by Name");
            System.out.println("8. Show Transaction Log");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Please enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:
                    addCustomer(sc);
                    break;

                case 2:
                    openAccount(sc);
                    break;

                case 3:
                    depositMoney(sc);
                    break;

                case 4:
                    withdrawMoney(sc);
                    break;

                case 5:
                    transferMoney(sc);
                    break;

                case 6:
                    showAllAccounts();
                    break;

                case 7:
                    searchByName(sc);
                    break;

                case 8:
                    showLog();
                    break;

                case 0:
                    System.out.println("Exiting program. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }

    static void addCustomer(Scanner sc) {

        sc.nextLine();
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        if (!InputValidator.checkMobile(mobile)) {
            System.out.println("Invalid mobile number. Customer not added.");
            return;
        }

        if (!InputValidator.checkEmail(email)) {
            System.out.println("Invalid email. Customer not added.");
            return;
        }

        Customer c = new Customer(name, mobile, email);
        customerList.add(c);

        System.out.println("Customer added with ID: " + c.getId());
    }

    static void openAccount(Scanner sc) {

        if (customerList.isEmpty()) {
            System.out.println("No customers yet. Add a customer first.");
            return;
        }

        sc.nextLine();
        System.out.print("Enter customer ID: ");
        String custId = sc.nextLine();

        Customer owner = null;
        for (Customer c : customerList) {
            if (c.getId().equals(custId)) {
                owner = c;
            }
        }

        if (owner == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("Enter opening balance: ");
        double startBalance = sc.nextDouble();

        if (startBalance < 0) {
            System.out.println("Opening balance cannot be negative.");
            return;
        }

        BankAccount acc = new BankAccount(nextAccNo, owner, startBalance);
        nextAccNo++;

        accountList.add(acc);
        logList.add("Account opened: " + acc.getAccNo() + " for " + owner.getName());

        System.out.println("Account created successfully. Account No: " + acc.getAccNo());
    }

    static BankAccount findAccount(int accNo) {

        for (BankAccount a : accountList) {
            if (a.getAccNo() == accNo) {
                return a;
            }
        }

        return null;
    }

    static void depositMoney(Scanner sc) {

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();

        if (amt <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }

        acc.deposit(amt);
        logList.add("Deposit of " + amt + " into " + accNo);

        System.out.println("New balance: " + acc.getBalance());
    }

    static void withdrawMoney(Scanner sc) {

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();

        boolean ok = acc.withdraw(amt);

        if (ok) {
            logList.add("Withdraw of " + amt + " from " + accNo);
            System.out.println("New balance: " + acc.getBalance());
        } else {
            System.out.println("Withdraw failed. Check amount or balance.");
        }
    }

    static void transferMoney(Scanner sc) {

        System.out.print("Enter your account number: ");
        int fromAcc = sc.nextInt();

        System.out.print("Enter receiver account number: ");
        int toAcc = sc.nextInt();

        if (fromAcc == toAcc) {
            System.out.println("Cannot transfer to the same account.");
            return;
        }

        BankAccount source = findAccount(fromAcc);
        BankAccount target = findAccount(toAcc);

        if (source == null || target == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();

        boolean ok = source.withdraw(amt);

        if (!ok) {
            System.out.println("Transfer failed. Check amount or balance.");
            return;
        }

        target.deposit(amt);
        logList.add("Transfer of " + amt + " from " + fromAcc + " to " + toAcc);

        System.out.println("Transfer successful.");
        System.out.println("Your new balance: " + source.getBalance());
    }

    static void showAllAccounts() {

        if (accountList.isEmpty()) {
            System.out.println("No accounts to show.");
            return;
        }

        for (BankAccount a : accountList) {
            System.out.println(a);
        }
    }

    static void searchByName(Scanner sc) {

        sc.nextLine();
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (BankAccount a : accountList) {
            if (a.getOwner().getName().equalsIgnoreCase(name)) {
                System.out.println(a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No account found under that name.");
        }
    }

    static void showLog() {

        if (logList.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        System.out.println("----- Transaction Log -----");

        for (String entry : logList) {
            System.out.println(entry);
        }
    }
}

class Customer {

    private static int counter = 1;

    private String id;
    private String name;
    private String mobile;
    private String email;

    public Customer(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.id = "CUS" + counter;
        counter++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}

class BankAccount {

    private int accNo;
    private Customer owner;
    private double balance;

    public BankAccount(int accNo, Customer owner, double balance) {
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

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance = balance + amt;
    }

    public boolean withdraw(double amt) {

        if (amt <= 0) {
            return false;
        }

        if (amt > balance) {
            return false;
        }

        balance = balance - amt;
        return true;
    }

    @Override
    public String toString() {
        return "AccNo: " + accNo + " | Owner: " + owner.getName() + " | Balance: " + balance;
    }
}

class InputValidator {

    private static final Pattern MOBILE_REGEX = Pattern.compile("^[6-9]\\d{9}$");
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public static boolean checkMobile(String mobile) {
        return MOBILE_REGEX.matcher(mobile).matches();
    }

    public static boolean checkEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }
}