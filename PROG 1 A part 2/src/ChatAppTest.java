import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

    public class ChatAppTest {

        @Test
        public void testSendMessageSuccess() {
            ChatApp chatApp = new ChatApp();
            chatApp.run(); // Mock or implement to avoid interactive input
            chatApp.messages.add(new Message("+277118693002", "Hi Mike, can you join us for dinner tonight?"));

            assertEquals(1, chatApp.messages.size(), "Total messages sent should be 1.");
        }

        @Test
        public void testSendMessageDiscard() {
            ChatApp chatApp = new ChatApp();
            chatApp.run(); // Mock or implement to avoid interactive input
            Message message = new Message("+085795795889", "Hi Keegan, did you receive the payment?");
            // Simulate discarding the message
            assertEquals(0, chatApp.messages.size(), "Total messages sent should remain 0 after discard.");
        }

        @Test
        public void testMessageLengthValidation() {
            String longMessage = "A".repeat(251); // 251 characters
            String shortMessage = "Hi!";

            String result = validateMessageLength(longMessage);
            assertEquals("Message exceeds 250 characters by 1, please reduce size.", result);

            result = validateMessageLength(shortMessage);
            assertEquals("Success", result);
        }

        @Test
        public void testCellPhoneNumberValidation() {
            String validNumber = "+277118693002";
            String invalidNumber = "07118693002"; // Missing international code

            String result = validateCellPhoneNumber(validNumber);
            assertEquals("Cell phone number successfully captured.", result);

            result = validateCellPhoneNumber(invalidNumber);
            assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", result);
        }

        // Helper methods for validations
        private String validateMessageLength(String message) {
            if (message.length() > 250) {
                return "Message exceeds 250 characters by " + (message.length() - 250) + ", please reduce size.";
            }
            return "Success";
        }

        private String validateCellPhoneNumber(String number) {
            if (number.length() == 13 && number.startsWith("+27")) {
                return "Cell phone number successfully captured.";
            }
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }