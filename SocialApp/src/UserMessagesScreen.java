public class UserMessagesScreen extends Screen {
    @Override
    public void process() {
        while (true) {
            System.out.println("All users");
            for (User user : userRepository.getAll()) {
                if (!loggedInUser.getUsername().equals(user.getUsername())) {
                    System.out.println(user.getUsername());
                }
            }
            System.out.println("Input some user's username");
            String someUsername = getStringFromUser();
            User target = userRepository.getByUsername(someUsername);

            if (target != null && !(target.getUsername().equals(loggedInUser.getUsername()))) {
                PersonalMessageScreen personalMessageScreen = new PersonalMessageScreen(target);
                personalMessageScreen.process();
                break;
            } else {
                System.out.println("No user with this username");
            }
        }
    }
}
