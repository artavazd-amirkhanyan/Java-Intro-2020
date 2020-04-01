public class StartScreen extends Screen {
    public void process() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            int i = getIntegerFromUser();
            if (i == 1) {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.process();
                break;
            } else if (i == 2) {
                RegistrationScreen registrationScreen = new RegistrationScreen();
                registrationScreen.process();
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
    }
}
