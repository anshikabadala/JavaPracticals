package Q1;
class PasswordChecker{

    public static boolean hasLength(String password){
        return password.length() >= 8;
    }

    public static boolean hasuppercase(String password){
        return password.matches(".*[A-Z].*");
    }

    public static boolean hasDigit(String password){
        return password.matches(".*[0-9].*");
    }

    public static boolean hasSpecialchar(String password){
        // return password.matches(".*^[A-Z][a-z][0-9].*");
        return password.matches(".*[\\W].*");
    }


    public static String isStrongPassword(String password){
        int count = 0;
        if(hasLength(password)){
            count++;
        }
        if(hasuppercase(password)){
            count++;
        }
        if(hasDigit(password)){
            count++;
        }
        if(hasSpecialchar(password)){
            count++;
        }

        if(count <= 3){
            return "Weak Password";
        }else if(count <= 3){
            return "Medium Password";
        }
        else {
            return "Strong Password";
        }
    }
}

