
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

    public class ChatApp extends Login {
        public List<Message> messages = new ArrayList<>();

        public void run() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to QuickChat!");

            String username = null;
            String password = null;

            while (true) {
                System.out.print("1: Login\n2: Quit\nChoose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (option == 1) {
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    System.out.println(loginUser(username, password));
                } else if (option == 2) {
                    System.out.println("Exiting...");
                    break;
                }

                if (username != null && password != null) {
                    while (true) {
                        System.out.print("1: Send Messages\n2: Show Recently Sent Messages\n3: Quit\nChoose an option: ");
                        int featureOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (featureOption == 1) {
                            System.out.print("Enter recipient's cell number: ");
                            String recipient = scanner.nextLine();
                            System.out.print("Enter your message: ");
                            String messageText = scanner.nextLine();

                            if (messageText.length() > 250) {
                                System.out.println("Please enter a message of less than 250 characters.");
                                continue;
                            }

                            Message message = new Message(recipient, messageText);
                            messages.add(message);
                            System.out.println("Message sent!");
                            System.out.println("Message Hash: " + message.getHash());
                        } else if (featureOption == 2) {
                            System.out.println("Coming Soon.");
                        } else if (featureOption == 3) {
                            System.out.println("Exiting...");
                            break;
                        }
                    }
                }
            }

            scanner.close();
        }

        public void storeMessagesToJSON() {
            try (FileWriter file = new FileWriter("ChatGPT.json")) {
                file.write("[\n");
                for (Message message : messages) {
                    file.write("{\n");
                    file.write("\"messageId\": \"" + message.getMessageId() + "\",\n");
                    file.write("\"recipient\": \"" + message.getRecipient() + "\",\n");
                    file.write("\"text\": \"" + message.getText() + "\"\n");
                    file.write("},\n");
                }
                file.write("]\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

