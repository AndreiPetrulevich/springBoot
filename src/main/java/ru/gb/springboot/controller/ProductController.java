package ru.gb.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.gb.springboot.config.ProductProps;
import ru.gb.springboot.model.Product;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductProps productProps;

    @GetMapping("/message")
    public String helloMessageJsp(Model model) {
        if (!CollectionUtils.isEmpty(productProps.getProducts())) {
            model.addAttribute("msg", productProps.getProducts().size());
        }
        return "message";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String processForm(Product product) {
        if (product.getId() == null) {
            productProps.addProduct(product);
        } else {
            productProps.editProduct(product);
        }
        return "redirect:/product/allProducts";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Integer id) {

        Optional<Product> product = null;
        if (id > 0) {
            try {
                product = productProps.getById(id);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(path = "/allProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("products", productProps.getAllProducts());
        log.info("model info: {}", model.toString());
        return "product-list";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteByID(@RequestParam Integer id) {
        log.info("deleted: {}", id);
        try {
            productProps.deleteProductById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "redirect:/product/allProducts";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String edit(Model model, @RequestParam Integer id) {
        try {
            model.addAttribute("product", productProps.getById(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return "add-product";
    }
}