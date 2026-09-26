import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// NotBlank annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

// MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// SignupForm class
class SignupForm {

    @NotBlank
    String name;

    @NotBlank
    @MaxLength(10)
    String username;

    @NotBlank
    @MaxLength(20)
    String password;

    SignupForm(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}

// Validator class
class FormValidator {

    public static List<String> validate(Object obj) {

        List<String> errors = new ArrayList<>();

        // Get all fields of the object
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);

                String value = (String) field.get(obj);

                // Check @NotBlank
                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null || value.trim().isEmpty()) {
                        errors.add(field.getName() + " cannot be blank");
                    }
                }

                // Check @MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength max = field.getAnnotation(MaxLength.class);

                    if (value != null && value.length() > max.value()) {
                        errors.add(field.getName()
                                + " cannot be more than "
                                + max.value() + " characters");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error while checking field");
            }
        }

        return errors;
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "verylongusername123",
                "mypassword"
        );

        List<String> errors = FormValidator.validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}