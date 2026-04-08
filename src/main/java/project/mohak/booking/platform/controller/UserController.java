package project.mohak.booking.platform.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mohak.booking.platform.exception.InvalidInputException;
import project.mohak.booking.platform.model.User;
import project.mohak.booking.platform.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uId}")
    public User getUser(@PathVariable String uId) {
        if (!userService.checkIfUserExistsById(uId))
            throw new InvalidInputException("Invalid User id : " + uId);

        return userService.getUser(uId);
    }

    @PostMapping
    public String createUser(@NonNull String uId, @NonNull String uName) {
        return userService.createUser(uId, uName);
    }
}
