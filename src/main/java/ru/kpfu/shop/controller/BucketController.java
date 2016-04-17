package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.shop.model.Bucket;
import ru.kpfu.shop.model.ShippingInfo;
import ru.kpfu.shop.repository.BucketRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.BucketService;
import ru.kpfu.shop.service.OrderService;
import ru.kpfu.shop.util.SecurityUtils;

import java.util.List;

@Controller
@RequestMapping(value = "/bucket")
public class BucketController {

    @Autowired
    BucketService bucketService;

    @Autowired
    BucketRepository bucketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderService orderService;

    /**
     * Добавление продукта в корзину
     * @param id
     */
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addProduct(@RequestParam Long id) {
        bucketService.addProduct(id);
    }

    /**
     * Удаление продукта из корзины
     * @param id
     */
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProduct(@RequestParam Long id) {
        bucketService.deleteProduct(id);
    }

    /**
     * Изменение количества товаров в корзине
     * @param id
     * @param number
     */
    @RequestMapping(value = "/changeNumberProduct", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void changeNumberProduct(@RequestParam("id") Long id, @RequestParam("number") Integer number) {
        bucketService.changeNumberProduct(id, number);
    }

    /**
     * Отображение всех товаров в корзине
     * @param model
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getBucketPage(Model model) {
        model.addAttribute("buckets", bucketRepository.findAllByUser(SecurityUtils.getCurrentUser()));
        return "basket";
    }

    /**
     * Страница с подтверждением покупки
     * @param model
     * @return
     */
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public String buyProductsPage(Model model) {
        List<Bucket> bucketList = bucketRepository.findAllByUser(SecurityUtils.getCurrentUser());
        ShippingInfo shippingInfo = userRepository.findOne(SecurityUtils.getCurrentUser().getId()).getShippingInfo();

        Integer sum = 0;
        for (Bucket bucket : bucketList) {
            sum += (bucket.getNumberProduct() * bucket.getProduct().getPrice());
        }
        model.addAttribute("buckets", bucketList);
        model.addAttribute("shipping", shippingInfo);
        model.addAttribute("sum", sum);

        return "order";

    }

    @RequestMapping(value = "/buyProducts", method = RequestMethod.POST)
    public void buyProducts() {
        orderService.buyProducts();
    }


}
