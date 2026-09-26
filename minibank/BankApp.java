import exception.BankException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;
public static void main(String[] args) {

    Customer c1 =
            new Customer("Anshika", "9876543210", "a@gmail.com");

    Customer c2 =
            new Customer("Rahul", "9876543211", "r@gmail.com");

    BankAccount acc1 =
            new BankAccount(1001, c1, 5000);

    BankAccount acc2 =
            new BankAccount(1002, c2, 2000);


    // Lab-7 Annotation validation

    BankAccount wrongAccount =
            new BankAccount(1003, c1, -500);

    String[] errors =
            AnnotationValidator.validate(wrongAccount);

    System.out.println("Validation Errors:");

    for (String error : errors) {
        System.out.println(error);
    }


    // Lab-8 Exception example

    try {

        acc1.withdraw(6000);

    } catch (InsufficientFundsException e) {

        System.out.println(
                "Withdrawal failed: "
                + e.getMessage()
        );

    } catch (InvalidAmountException e) {

        System.out.println(
                "Invalid amount: "
                + e.getMessage()
        );
    }


    // Deposit example

    try {

        acc1.deposit(-100);

    } catch (InvalidAmountException e) {

        System.out.println(
                "Deposit failed: "
                + e.getMessage()
        );
    }


    // Transfer example

    try {

        acc1.transfer(acc2, 1000);

        System.out.println("Transfer successful.");

    } catch (BankException e) {

        System.out.println(
                "Transfer failed: "
                + e.getMessage()
        );

    } finally {

        System.out.println(
                "Transfer process finished."
        );
    }


    // Try-with-resources

    try (BankResource resource = new BankResource()) {

        System.out.println(
                "Using bank resource..."
        );

    }
}