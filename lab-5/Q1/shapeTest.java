import java.util.Scanner;

abstract class shape {
    abstract double area();
}

class circle extends shape{
    double radius;

    circle(double radius){
        this.radius = radius;
    }

    double area(){
        return 3.14 * radius  * radius;
    }
}

class rectangle extends shape{
    double l;
    double b;
    rectangle(double l,double b){
        this.l = l;
        this.b = b;
    }

    double area(){
        return l * b;
    }
}

class triangle extends shape{
    double b;
    double h;
    triangle(double b,double h){
        this.b = b;
        this.h = h;
    }

    double area(){
        return 0.5 * b * h;
    }
}

public class shapeTest {
    public static void main(String[] args) {
        

        System.out.println("enter the choice: 1. Circle 2. Rectangle 3. Triangle");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.println("Enter  the radius of circle : ");
            double radius = sc.nextDouble();
            shape c = new circle(radius);
            System.out.println("Area of Circle: " + c.area());
        }

        if(choice == 2){
            System.out.println("Enter the length and breadth of rectangle: ");
            double l = sc.nextDouble();
            double b = sc.nextDouble();
            shape r = new rectangle(l, b);
            System.out.println("Area of Rectangle: " + r.area());
        }

        if(choice == 3){
            System.out.println("Enter the base and height of triangle: ");
            double base = sc.nextDouble();
            double height = sc.nextDouble();
            shape t = new triangle(base, height);
            System.out.println("Area of Triangle: " + t.area());
        }

}
}