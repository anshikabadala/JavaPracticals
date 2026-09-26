import java.lang.annotation.*;
import java.lang.reflect.Method;

// Run annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

// Class containing test methods
class MyTests {

    @Run
    public void testLogin() {
        System.out.println("Login test passed");
    }

    @Run
    public void testSignup() {
        System.out.println("Signup test passed");
    }

    public void normalMethod() {
        System.out.println("This method should not run");
    }

    @Run
    public void testLogout() {
        System.out.println("Logout test passed");
    }
}

// Mini test runner
public class Main {

    public static void main(String[] args) {

        MyTests obj = new MyTests();

        int count = 0;

        // Get all methods
        Method[] methods = MyTests.class.getDeclaredMethods();

        for (Method method : methods) {

            // Check if method has @Run annotation
            if (method.isAnnotationPresent(Run.class)) {

                try {
                    // Run the method
                    method.invoke(obj);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error running test");
                }
            }
        }

        System.out.println("Total tests run: " + count);
    }
}