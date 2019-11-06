package ru.lulkast.controllers;

import org.springframework.ui.Model;

public interface UserController {

    String getById(String id, Model model) throws Throwable;

    String save(String userName, String password, Model model) throws  Throwable;

    String getAll(Model model) throws Throwable;

}
