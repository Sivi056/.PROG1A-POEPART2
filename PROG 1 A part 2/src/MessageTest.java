import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

    public class MessageTest {

        @Test
        public void testMessageCreation() {
            Message message = new Message("+277118693002", "Hi Mike, can you join us for dinner tonight?");
            assertNotNull(message.getMessageId(), "Message ID should be successfully created.");
            assertEquals("+277118693002", message.getRecipient(), "Recipient number should be captured correctly.");
        }

        @Test
        public void testMessageHashGeneration() {
            Message message = new Message("+277118693002", "Hi Mike, can you join us for dinner tonight?");
            String hash = message.getHash();
            assertTrue(hash.startsWith(message.getMessageId().substring(0, 2)), "Hash should start with the first two digits of Message ID.");
        }
    }
