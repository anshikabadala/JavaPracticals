import java.util.Scanner; 

abstract  class Employee {
    String name;
     int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double calculatepay();
}

class fulltime extends Employee{
    double salary;

    fulltime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    public double calculatepay(){
        return salary;
    }
}

class parttime extends Employee{
    double hr;
    double rate;

    parttime(String name, int id, double hr, double rate) {
        super(name, id);
        this.hr = hr;
        this.rate = rate;
    }

    public double calculatepay(){
        return hr * rate;
    }

}

class intern extends Employee{
    double stipend;

    intern(String name, int id, double stipend){
        super(name,id);
        this.stipend = stipend;
    }

   public double calculatepay(){
        return stipend;
    }
}

public class payroll{
    public static void main(String[] args){
        Employee[] e = new Employee[3];

        e[0] = new fulltime("Anshika",002,50000);
        e[1] = new parttime("shruti",001,20,200);
        e[2] = new intern("Riya",003,10000);

        System.out.println("....Payroll....");
        float totalpay = 0;
        for(Employee emp : e){
            System.out.println("Name: " + emp.name);
            System.out.println("ID: " + emp.id);
            System.out.println("Salary: " + emp.calculatepay());
            System.out.println();
              totalpay += emp.calculatepay();
        }
        System.out.println("Total Payroll: " + totalpay);
    }
}// import java.util.Scanner;

// abstract class Employee {
//     String name;
//     int id;

//     Employee(String name, int id) {
//         this.name = name;
//         this.id = id;
//     }

//     abstract double monthlySalary();
// }

// class FullTime extends Employee {
//     double salary;

//     FullTime(String name, int id, double salary) {
//         super(name, id);
//         this.salary = salary;
//     }

//     double monthlySalary() {
//         return salary;
//     }
// }

// class PartTime extends Employee {
//     double hours, rate;

//     PartTime(String name, int id, double hours, double rate) {
//         super(name, id);
//         this.hours = hours;
//         this.rate = rate;
//     }

//     double monthlySalary() {
//         return hours * rate;
//     }
// }

// class Intern extends Employee {
//     double stipend;

//     Intern(String name, int id, double stipend) {
//         super(name, id);
//         this.stipend = stipend;
//     }

//     double monthlySalary() {
//         return stipend;
//     }
// }

// public class payroll {
//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of employees: ");
//         int n = sc.nextInt();

//         Employee[] employees = new Employee[n];

//         // Input
//         for (int i = 0; i < n; i++) {

//             System.out.println("\nEmployee " + (i + 1));

//             System.out.print("Enter name: ");
//             String name = sc.next();

//             System.out.print("Enter ID: ");
//             int id = sc.nextInt();

//             System.out.println("1. FullTime");
//             System.out.println("2. PartTime");
//             System.out.println("3. Intern");
//             System.out.print("Enter choice: ");
//             int choice = sc.nextInt();

//             if (choice == 1) {

//                 System.out.print("Enter fixed salary: ");
//                 double salary = sc.nextDouble();

//                 employees[i] = new FullTime(name, id, salary);
//             }

//             else if (choice == 2) {

//                 System.out.print("Enter hours: ");
//                 double hours = sc.nextDouble();

//                 System.out.print("Enter rate: ");
//                 double rate = sc.nextDouble();

//                 employees[i] = new PartTime(name, id, hours, rate);
//             }

//             else if (choice == 3) {

//                 System.out.print("Enter stipend: ");
//                 double stipend = sc.nextDouble();

//                 employees[i] = new Intern(name, id, stipend);
//             }

//             else {
//                 System.out.println("Invalid choice. Try again.");
//                 i--;
//             }
//         }

//         // Display and calculate total
//         double total = 0;

//         System.out.println("\n----- Payroll Details -----");

//         for (int i = 0; i < employees.length; i++) {

//             System.out.println("\nName: " + employees[i].name);
//             System.out.println("ID: " + employees[i].id);

//             if (employees[i] instanceof FullTime) {
//                 System.out.println("Type: FullTime");
//             } else if (employees[i] instanceof PartTime) {
//                 System.out.println("Type: PartTime");
//             } else if (employees[i] instanceof Intern) {
//                 System.out.println("Type: Intern");
//                 System.out.println("Note: Intern receives a stipend.");
//             }

//             double salary = employees[i].monthlySalary();

//             System.out.println("Monthly Salary: " + salary);

//             total = total + salary;
//         }

//         System.out.println("\nTotal Payroll = " + total);

//         sc.close();
//     }
// }