package com.fullness.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // どのURLからアクセスするのかわからない

public class RegisterController {

    // 新商品登録画面へ遷移する
    @GetMapping
    public String showInput() {
        return "/admin/product-add";
    }

    // Formオブジェクトを初期化

}
