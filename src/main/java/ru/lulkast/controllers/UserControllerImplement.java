package ru.lulkast.controllers;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lulkast.exceptions.WrongArgumentException;
import ru.lulkast.models.User;
import ru.lulkast.services.UserService;

import java.util.Set;
import java.util.UUID;

@Controller
public class UserControllerImplement implements UserController {

    private UserService service;

    @Autowired
    public UserControllerImplement(UserService service) {
        this.service = service;
    }

    @GetMapping ("/user")
    @Override
    public String getUserById(@RequestParam("UUID") String id, Model model) throws Exception {
        if (Strings.isNullOrEmpty(id)) throw new WrongArgumentException("Null cant be applied");
        try {
            UUID uuid = UUID.fromString(id);
            final User user = service.getByUUID(uuid);
            System.out.println(user.toString());
            model.addAttribute("user", user);
            return "users/user";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping ("/user")
    @Override
    public String saveUser(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model) throws Exception {

        try {
            User user = new User(UUID.randomUUID(), userName, password);
            User saved = service.save(user);
            model.addAttribute("user", saved);
            return "users/user";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/user/all")
    @Override
    public String getAllUsers(Model model) throws Exception {
        final Set<User> allUsers = service.getAll();
        model.addAttribute("users", allUsers);
        return "users/usersAll";
    }
}
