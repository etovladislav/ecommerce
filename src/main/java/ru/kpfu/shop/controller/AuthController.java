package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.shop.repository.ProductRepository;


@Controller
public class AuthController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/")
    public String mainPage() {
        return "index";
    }

    /**
     *Страница входа
     * @param error
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error,
                               Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    /**
     * Страница с регистрацией пользователя
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationPage() {
        return "registration";
    }

    /**
     * Страница со всеми продуктами
     * @return
     */
    @RequestMapping(value = "/products")
    public String getProductsPage() {

        return "products";
    }

}
