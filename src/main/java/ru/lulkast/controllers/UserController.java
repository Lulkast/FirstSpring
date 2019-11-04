package ru.lulkast.controllers;

import org.springframework.ui.Model;

public interface UserController {

    String getUserById(String id, Model model) throws Exception;

    String saveUser(String userName, String password, Model model) throws Exception;

    String getAllUsers(Model model) throws Exception;

}
