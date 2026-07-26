class Customer implements Cloneable
{
    private String name;
    private String email;
    private String mobile;
    private final String customerId;
    private Address address;

    private static long customerCounter = 101;

    private static String generateCustomerId()
    {
        return "CUST" + customerCounter++;
    }

    public Customer(String name, String email, String mobile, Address address)
    {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.customerId = generateCustomerId();
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getMobile()
    {
        return mobile;
    }

    public String getCustomerId()
    {
        return customerId;
    }

    public Address getAddress()
    {
        return address;
    }

    // Nested Address Class
    public static class Address
    {
        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode)
        {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine()
        {
            return line;
        }

        public String getCity()
        {
            return city;
        }

        public String getPincode()
        {
            return pincode;
        }
    }

    public Customer clone() throws CloneNotSupportedException
    {
        return (Customer) super.clone();
    }
}

class Account
{
    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static int counter = 1;

    private static String generateAccountNumber()
    {
        return String.format("AC%04d", counter++);
    }

    public Account(String ownerName, long balance)
    {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    public Account(String ownerName)
    {
        this(ownerName, 0);
    }

    public void deposit(long amount)
    {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(long amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public long getBalance()
    {
        return balance;
    }

    public boolean isActive()
    {
        return active;
    }

    // toString()
    public String toString()
    {
        return "Account Number : " + accountNumber +
               "\nOwner Name : " + ownerName +
               "\nBalance : " + balance;
    }

    // equals()
    public boolean equals(Object obj)
    {
        Account a = (Account) obj;

        if (accountNumber.equals(a.accountNumber))
            return true;
        else
            return false;
    }

    // hashCode()
    public int hashCode()
    {
        return accountNumber.hashCode();
    }
}

public class MiniBank
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Customer.Address add1 =
                new Customer.Address("CG Road", "Ahmedabad", "380009");

        Customer c1 = new Customer(
                "Anshika",
                "anshika@gmail.com",
                "9999988888",
                add1);

        Customer c2 = c1.clone();

        System.out.println("Customer Details");
        System.out.println("----------------");
        System.out.println("ID : " + c1.getCustomerId());
        System.out.println("Name : " + c1.getName());
        System.out.println("City : " + c1.getAddress().getCity());

        System.out.println();

        Account a1 = new Account("Anshika", 50000);
        Account a2 = new Account("Ashu", 30000);

        a1.deposit(10000);
        a2.withdraw(5000);

        System.out.println("Account Details");
        System.out.println("----------------");
        System.out.println(a1);
        System.out.println();

        System.out.println(a2);

        System.out.println();

        System.out.println("Comparing Accounts");
        System.out.println(a1.equals(a2));

        System.out.println();

        if (a1 instanceof Account)
            System.out.println("a1 is an Account object");

        if (c2 instanceof Customer)
            System.out.println("c2 is a Customer object");
    }
}