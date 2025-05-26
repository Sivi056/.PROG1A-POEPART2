import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


    class RegistrationTest {

        Registration registration = new Registration();

        @Test
        void testInvalidUsername() {
            String result = registration.registerUser("kyle!!!!!!", "Password1!", "+27831234567");
            assertEquals("Username incorrectly formatted.", result);
        }



        @Test
        void testValidPassword() {
            assertTrue(registration.checkPasswordComplexity("Password1!"));
        }

        @Test
        void testInvalidPassword() {
            assertFalse(registration.checkPasswordComplexity("pass"));
        }

        @Test
        void testCellPhoneNumberCorrectlyFormatted() {
            assertTrue(registration.checkCellPhoneNumber("+27831234567"));
        }

        @Test
        void testCellPhoneNumberIncorrectlyFormatted() {
            assertFalse(registration.checkCellPhoneNumber("08966553")); // Invalid format
        }

        @Test
        void testInvalidCellPhoneNumber() {
            assertFalse(registration.checkCellPhoneNumber("08966553"));
        }
    }

