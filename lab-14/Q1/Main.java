
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StudentService service=new StudentService();

        while(true){
            System.out.println("1.Add Student");
            System.out.println("2.View Count");
            System.out.println("3.Exit");
            System.out.print("Enter choice: ");

            int choice=sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("Enter ID: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name=sc.nextLine();

                    try{
                        service.addStudent(new Student(id,name));
                        System.out.println("Student added successfully");
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Total Students: "+service.getCount());
                    break;

                case 3:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}