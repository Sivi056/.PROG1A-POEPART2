import java.util.Random;

    public class Message {
        private static int messageCount = 0;
        private final String messageId;
        private final String recipient;
        private final String text;

        public Message(String recipient, String text) {
            this.messageId = generateMessageId();
            this.recipient = recipient;
            this.text = text;
            messageCount++;
        }

        private String generateMessageId() {
            Random rand = new Random();
            return String.format("%010d", rand.nextInt(1000000000));
        }

        public String getMessageId() {
            return messageId;
        }

        public String getHash() {
            String[] words = text.split(" ");
            String firstWord = words.length > 0 ? words[0] : "";
            String lastWord = words.length > 1 ? words[words.length - 1] : "";
            return messageId.substring(0, 2) + ":" + messageCount + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
        }

        public String getRecipient() {
            return recipient;
        }

        public String getText() {
            return text;
        }
    }
