public class PersonalMessageScreen extends Screen {
    private User to;

    public PersonalMessageScreen(User to) {
        this.to = to;
    }

    @Override
    public void process() {
        System.out.println("Your messages from " + to.getUsername());
        for (Message message : loggedInUser.getMessages()) {
            if (message.getFrom().getUsername().equals(to.getUsername())) {
                System.out.println(message.getMessage());
            }
        }
        System.out.println("Write message");
        String message = getStringFromUser();
        Message message1 = new Message(message, loggedInUser, to);
        to.getMessages().add(message1);
        System.out.println("Message sent");
        UserHomeScreen userHomeScreen = new UserHomeScreen();
        userHomeScreen.process();
    }
}
