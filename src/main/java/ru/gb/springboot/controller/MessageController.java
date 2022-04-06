package ru.gb.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import ru.gb.springboot.config.ProductProps;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final ProductProps productProps;

    @GetMapping("/message")
    public String helloMessageJsp(Model model) {
        if (!CollectionUtils.isEmpty(productProps.getProducts())) {
            model.addAttribute("msg", productProps.getProducts().size());
        }
        return "message";
    }


}
