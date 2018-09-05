package py.com.rentacar.service;

import py.com.rentacar.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author mmartinez
 */
public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(1, "mmartinez", "superSecret"));
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public void create(User user) {
        users.add(user);
    }

}
