package ru.kpfu.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.shop.form.ProductForm;
import ru.kpfu.shop.form.ProductFormUpdate;
import ru.kpfu.shop.model.Category;
import ru.kpfu.shop.model.Order;
import ru.kpfu.shop.model.ShippingInfo;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.OrderRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.repository.UserRepository;
import ru.kpfu.shop.service.ProductService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Страница админа
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getAdminPage(Model model, HttpServletResponse httpServletResponse) {
        model.addAttribute("categories", categoryRepository.findAll());
        httpServletResponse.setHeader("X-Frame-Options", "GOFORIT");
        return "HelloGwt";
    }

    /**
     * Страница добавления товара из админ панели
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add-product", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "add-product";
    }

    /**
     * Добавление товара в админ панеле
     *
     * @param productForm
     * @return
     */
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String newProduct(@ModelAttribute ProductForm productForm) {
        productService.saveProduct(productForm);
        return "redirect:/admin/add-product";
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public void updateProduct(@ModelAttribute ProductFormUpdate productFormUpdate) {
        productService.updateProduct(productFormUpdate);
    }
    /**
     * Страница добавления категории
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public String addCategory(Model model) {
        return "add-category";
    }

    /**
     * Создание новой категории из админ панели
     *
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public String saveCategory(@RequestParam String name, Model model) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "add-category";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders-list-admin";
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrderDetail(@PathVariable("id") Long id, Model model) {
        Order order = orderRepository.findOne(id);
        model.addAttribute("order", order);
        ShippingInfo shippingInfo = userRepository.findOne(order.getUser().getId()).getShippingInfo();
        model.addAttribute("shipping", shippingInfo);
        return "order-detail";
    }
}
