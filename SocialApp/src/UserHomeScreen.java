public class UserHomeScreen extends Screen {
    @Override
    public void process() {
        while (true) {
            System.out.println("1. Messages");
            System.out.println("2. Log Out");
            int i = getIntegerFromUser();
            if (i ==1) {
                UserMessagesScreen userMessagesScreen = new UserMessagesScreen();
                userMessagesScreen.process();
                break;
            } else if (i == 2) {
                System.out.println("Logged out");
                loggedInUser = null;
                StartScreen startScreen = new StartScreen();
                startScreen.process();
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
