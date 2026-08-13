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

        shape c = new circle(5);
        shape r = new rectangle(4, 6);
        shape t = new triangle(3, 8);

        System.out.println("Area of Circle: " + c.area());
        System.out.println("Area of Rectangle: " + r.area());
        System.out.println("Area of Triangle: " + t.area());

        double totalArea = c.area() + r.area() + t.area();
        System.out.println("Total Area: " + totalArea);

        double largestarea = 0;
        shape largestshape = null;

        for (shape s : new shape[] { c, r, t }) {
            if (s.area() > largestarea) {
                largestarea = s.area();
                largestshape = s;
            }
        }
        System.out.println("Largest Area: " + largestarea);
        System.out.println("Largest Shape: " + largestshape.getClass().getSimpleName());
    }
}