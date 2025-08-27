package com.fullness.ec.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class MenuController {

    @GetMapping()
    public String getMenuPage() {
        return "admin/menu"; // templates/menu.html を返す（Thymeleafなど）
    }
}