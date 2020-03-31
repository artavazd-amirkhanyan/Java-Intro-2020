import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static User loggedInUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            int i = scanner.nextInt();
            if (i == 1) {
                goLoginScreen();
                break;
            } else if (i == 2) {
                goRegistrationScreen();
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void goStartPage() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            int i = scanner.nextInt();
            if (i == 1) {
                goLoginScreen();
                break;
            } else if (i == 2) {
                goRegistrationScreen();
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void goLoginScreen() {
        System.out.println("Input username");
        String username = scanner.next();
        System.out.println("Input password");
        String password = scanner.next();
        boolean foundUser = false;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                foundUser = true;
                System.out.println("Login successful");
                loggedInUser = user;
                goUserHomePage();
                break;
            }
        }
        if (!foundUser) {
            System.out.println("Wrong username password");
            goLoginScreen();
        }
    }

    public static void goUserHomePage() {
        while (true) {
            System.out.println("1. Messages");
            System.out.println("2. Log Out");
            int i = scanner.nextInt();
            if (i ==1) {
                goMessagesScreen();
                break;
            } else if (i == 2) {
                System.out.println("Logged out");
                loggedInUser = null;
                goStartPage();
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public static void goMessagesScreen() {
        System.out.println("All users");
        for (User user : users) {
            if (!loggedInUser.getUsername().equals(user.getUsername())) {
                System.out.println(user.getUsername());
            }
        }
        System.out.println("Input some user's username");
        String someUsername = scanner.next();
        User target = null;
        for (User user : users) {
            if (user.getUsername().equals(someUsername)) {
                target = user;
                break;
            }
        }

        if (target != null && !(target.getUsername().equals(loggedInUser.getUsername()))) {
            goPM(target);
        } else {
            System.out.println("No user with this username");
            goMessagesScreen();
        }
    }

    public static void goPM(User target) {
        System.out.println("Your messages from " + target.getUsername());
        for (Message message : loggedInUser.getMessages()) {
            if (message.getFrom().getUsername().equals(target.getUsername())) {
                System.out.println(message.getMessage());
            }
        }
        System.out.println("Write message");
        String message = scanner.next();
        Message message1 = new Message(message, loggedInUser, target);
        target.getMessages().add(message1);
        System.out.println("Message sent");
        goUserHomePage();

    }

    public static void goRegistrationScreen() {
        System.out.println("Input username");
        String username = scanner.next();
        boolean foundUser = false;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Try again");
                foundUser = true;
                break;
            }
        }

        if (foundUser) {
            goRegistrationScreen();
        } else {
            System.out.println("Input password");
            String password = scanner.next();
            User user = new User(username, password);
            users.add(user);
            System.out.println("Successfully created new user with username " + username);
            goStartPage();
        }
    }
}
