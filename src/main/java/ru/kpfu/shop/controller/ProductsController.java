package ru.kpfu.shop.controller;

import org.apache.poi.ss.formula.functions.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.shop.repository.CategoryRepository;
import ru.kpfu.shop.repository.ProductRepository;
import ru.kpfu.shop.service.ProductService;


@Controller
public class ProductsController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    /**
     * СТраница с продуктами, есть два необязательных параметра, это группировка по категории
     * и фильтрация по цене и имени
     *
     * @param categoryId
     * @param filter
     * @param model
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProductsPage(@RequestParam(name = "category", required = false) Long categoryId,
                                  @RequestParam(name = "filter", required = false) String filter,
                                  Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        if (filter != null) {
            //Смотрим какой параметр фильтрации пришел и обращаемся к нужному методу репозитория
            switch (filter) {
                case "priceUp":
                    model.addAttribute("products", productRepository.findAllByOrderByPriceDesc());
                    break;
                case "priceDown":
                    model.addAttribute("products", productRepository.findAllByOrderByPriceAsc());
                    break;
                case "nameUp":
                    model.addAttribute("products", productRepository.findAllByOrderByNameDesc());
                    break;
                case "nameDown":
                    model.addAttribute("products", productRepository.findAllByOrderByNameAsc());
                    break;
                default:
                    model.addAttribute("products", productRepository.findAll());
                    break;
            }
            return "products";
        }
        if (categoryId == null) {
            model.addAttribute("products", productRepository.findAll());
        } else {
            model.addAttribute("products", productService.findByCategoryId(categoryId));
        }
        return "products";
    }

    /**
     * Детальное отображение продукта
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping(value = "/products/detail", method = RequestMethod.GET)
    public String detailProduct(@RequestParam("id") Long productId, Model model) {
        model.addAttribute("product", productRepository.findOne(productId));
        return "shop-item";
    }
}
