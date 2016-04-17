package ru.kpfu.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.shop.form.UserForm;
import ru.kpfu.shop.service.UserService;


@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    /**
     * Регистрация пользователя, данные из запроса поступают в UserForm
     * @param userForm
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute UserForm userForm) {

        userService.registrateUser(userForm);
        return "redirect:/login";
    }

    /**
     * Проверка занятости логина
     * @param login
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    @ResponseBody
    public String checkLogin(@RequestParam String login) {
        Boolean isExists = userService.checkLogin(login);
        return isExists.toString();
    }

}
