package Q1;

public class driver {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.println(PasswordChecker.isStrongPassword(password));

        sc.close();
    }
}