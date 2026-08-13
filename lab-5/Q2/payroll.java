import java.util.Scanner;

abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    double hours, rate;

    PartTime(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    double monthlySalary() {
        return stipend;
    }
}

public class payroll {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        // Input
        for (int i = 0; i < n; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.println("1. FullTime");
            System.out.println("2. PartTime");
            System.out.println("3. Intern");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter fixed salary: ");
                double salary = sc.nextDouble();

                employees[i] = new FullTime(name, id, salary);
            }

            else if (choice == 2) {

                System.out.print("Enter hours: ");
                double hours = sc.nextDouble();

                System.out.print("Enter rate: ");
                double rate = sc.nextDouble();

                employees[i] = new PartTime(name, id, hours, rate);
            }

            else if (choice == 3) {

                System.out.print("Enter stipend: ");
                double stipend = sc.nextDouble();

                employees[i] = new Intern(name, id, stipend);
            }

            else {
                System.out.println("Invalid choice. Try again.");
                i--;
            }
        }

        // Display and calculate total
        double total = 0;

        System.out.println("\n----- Payroll Details -----");

        for (int i = 0; i < employees.length; i++) {

            System.out.println("\nName: " + employees[i].name);
            System.out.println("ID: " + employees[i].id);

            if (employees[i] instanceof FullTime) {
                System.out.println("Type: FullTime");
            } else if (employees[i] instanceof PartTime) {
                System.out.println("Type: PartTime");
            } else if (employees[i] instanceof Intern) {
                System.out.println("Type: Intern");
                System.out.println("Note: Intern receives a stipend.");
            }

            double salary = employees[i].monthlySalary();

            System.out.println("Monthly Salary: " + salary);

            total = total + salary;
        }

        System.out.println("\nTotal Payroll = " + total);

        sc.close();
    }
}