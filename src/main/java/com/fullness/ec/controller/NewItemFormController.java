package com.fullness.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullness.ec.form.NewItemForm;

public class NewItemFormController {

    @Controller
    @RequestMapping("/form")
    public class FormController {
        @ModelAttribute("newItemForm")
        public NewItemForm setupForm() {
            return new NewItemForm();
        }
    }

    @GetMapping("//admin/product-add")
    public String input() {
        return "/admin/product-add";
    }
}
