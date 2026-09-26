import java.util.regex.Pattern;

class InputValidator {

    private static final Pattern MOBILE_REGEX =
            Pattern.compile("^[6-9]\\d{9}$");

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w.+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    public static boolean checkMobile(String mobile) {
        return MOBILE_REGEX.matcher(mobile).matches();
    }

    public static boolean checkEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }
}