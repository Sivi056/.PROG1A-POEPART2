public class Registration {
    public String[] registeredUsers = new String[10];
    String[] passwords = new String[10];
    public int userCount = 0;

    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        if (userCount < registeredUsers.length) {
            registeredUsers[userCount] = username;
            passwords[userCount] = password;
            userCount++;
            return "Registration successful!";
        } else {
            return "User limit reached.";
        }
    }

    protected boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    protected boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (isSpecialCharacter(c)) hasSpecialChar = true;
        }

        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    private boolean isSpecialCharacter(char c) {
        String specialChars = "!@#$%^&*(),.?\":{}|<>";
        return specialChars.indexOf(c) >= 0;
    }

    protected boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber.length() == 13 && cellPhoneNumber.startsWith("+27");
    }
}