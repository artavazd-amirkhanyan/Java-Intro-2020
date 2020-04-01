public class LoginScreen extends Screen {

    public void process() {
        while (true) {
            System.out.println("Input username");
            String username = getStringFromUser();
            System.out.println("Input password");
            String password = getStringFromUser();
            User user = userRepository.getByUsernameAndPassword(username, password);
            if (user == null) {
                System.out.println("Wrong username password");
                continue;
            }
            System.out.println("Login successful");
            loggedInUser = user;
            UserHomeScreen userHomeScreen = new UserHomeScreen();
            userHomeScreen.process();
            break;
        }
    }
}
