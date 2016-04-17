package ru.kpfu.shop.service;

import ru.kpfu.shop.form.UserForm;


public interface UserService{

    void registrateUser(UserForm userForm);

    boolean checkLogin(String login);
}
