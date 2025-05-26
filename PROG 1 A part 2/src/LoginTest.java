import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    Login login = new Login();

    @Test
    void testLoginSuccessful() {
        // Register a user first for testing login
        login.registerUser("kyl_1", "Password1!", "+27831234567");

        String result = login.loginUser("kyl_1", "Password1!");
        assertEquals("Welcome kyl_1. It is great to see you again.", result);
    }

    @Test
    void testLoginFailed() {
        // Attempt to login with incorrect credentials
        String result = login.loginUser("wrong_user", "wrong_pass");
        assertEquals("Username or password incorrect, please try again.", result);
    }

    @Test
    void testUsernameCorrectlyFormatted() {
        // Test a correctly formatted username
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    void testUsernameIncorrectlyFormatted() {
        // Test an incorrectly formatted username
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    void testPasswordMeetsComplexity() {
        // Test a valid password
        assertTrue(login.checkPasswordComplexity("Password1!"));
    }

    @Test
    void testPasswordDoesNotMeetComplexity() {
        // Test an invalid password
        assertFalse(login.checkPasswordComplexity("pass"));
    }

    @Test
    void testCellPhoneNumberCorrectlyFormatted() {
        // Test a correctly formatted cell phone number
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }

    @Test
    void testCellPhoneNumberIncorrectlyFormatted() {
        // Test an incorrectly formatted cell phone number
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}