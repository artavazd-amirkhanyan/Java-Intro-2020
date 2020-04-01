import java.util.Scanner;

public abstract class Screen {
    private static Scanner scanner = new Scanner(System.in);
    protected static UserRepository userRepository = new UserRepository();
    protected static User loggedInUser = null;

    protected int getIntegerFromUser() {
        return scanner.nextInt();
    }

    protected String getStringFromUser() {
        return scanner.next();
    }

    public abstract void process();
}
