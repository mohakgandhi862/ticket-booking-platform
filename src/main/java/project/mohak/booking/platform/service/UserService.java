package project.mohak.booking.platform.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import project.mohak.booking.platform.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public String createUser(@NonNull String userId, @NonNull String name) {
        users.add(new User(userId, name));
        return userId;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(@NonNull String uId) {
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(uId)) {
                return user;
            }
        }

        return null;
    }

    public boolean checkIfUserExistsById(String uId) {
        for (User user : users) {
            if (user.getId().equalsIgnoreCase(uId)) {
                return true;
            }
        }

        return false;
    }
}
