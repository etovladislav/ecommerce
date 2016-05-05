package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.shop.model.ShippingInfo;
import ru.kpfu.shop.model.User;
import ru.kpfu.shop.repository.ShippingRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.util.SecurityUtils;

import static org.springframework.web.util.HtmlUtils.htmlEscape;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShippingRepository shippingRepository;



    /**
     * Страница с информацией о доставке
     * Если пользователь еще не заполнял то возвращаем shipping-info
     * иначе shipping
     * @param model
     * @return
     */
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getSettingsPage(Model model) {
        ShippingInfo shippingInfo = userRepository.findOne(SecurityUtils.getCurrentUser().getId()).getShippingInfo();
        if (shippingInfo != null) {
            model.addAttribute("shipping", shippingInfo);
            return "shipping";
        }
        return "shipping-info";
    }

    /**
     * Сохранение или обновление информации о доставке
     * @param shippingInfo
     * @param model
     * @return
     */
    @RequestMapping(value = "/shipping", method = RequestMethod.POST)
    public String saveShippingInfo(@ModelAttribute ShippingInfo shippingInfo, Model model) {
        User user = userRepository.findOne(SecurityUtils.getCurrentUser().getId());
        shippingInfo.setCity(htmlEscape(shippingInfo.getCity()));
        shippingInfo.setCountry(htmlEscape(shippingInfo.getCity()));
        shippingInfo.setEmail(htmlEscape(shippingInfo.getEmail()));
        shippingInfo.setFio(htmlEscape(shippingInfo.getFio()));
        shippingInfo.setHouse(htmlEscape(shippingInfo.getHouse()));
        shippingInfo.setPhone(htmlEscape(shippingInfo.getPhone()));
        shippingInfo.setStreet(htmlEscape(shippingInfo.getStreet()));
        user.setShippingInfo(shippingRepository.save(shippingInfo));
        userRepository.save(user);
        return "redirect:/products";
    }
}
