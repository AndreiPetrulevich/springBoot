package ru.gb.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @GetMapping("/message")
    public String helloMessageJsp(Model model) {
        model.addAttribute("msg", "hello spring boot");
        return "message";
    }
}
