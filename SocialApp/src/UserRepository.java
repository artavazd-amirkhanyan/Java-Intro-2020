import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void save(User user) {
        users.add(user);
    }

    public boolean checkIfExistsByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User getByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getAll() {
        return users;
    }
}
