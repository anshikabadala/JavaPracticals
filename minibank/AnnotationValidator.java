import java.lang.reflect.Field;
import java.util.ArrayList;
import model.annotation.MaxLength;
import model.annotation.Positive;

public class AnnotationValidator {

    public static String[] validate(Object obj) {

        ArrayList<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {

                field.setAccessible(true);

                // Check Positive
                if (field.isAnnotationPresent(Positive.class)) {

                    long value = field.getLong(obj);

                    if (value <= 0) {

                        Positive p =
                                field.getAnnotation(Positive.class);

                        errors.add(
                                field.getName()
                                + " "
                                + p.message()
                        );
                    }
                }

                // Check MaxLength
                if (field.isAnnotationPresent(MaxLength.class)) {

                    Object value = field.get(obj);

                    if (value != null) {

                        MaxLength max =
                                field.getAnnotation(MaxLength.class);

                        String text = value.toString();

                        if (text.length() > max.value()) {

                            errors.add(
                                    field.getName()
                                    + " is too long"
                            );
                        }
                    }
                }

            } catch (Exception e) {

                errors.add(
                        "Error checking " + field.getName()
                );
            }
        }

        return errors.toArray(new String[0]);
    }
}