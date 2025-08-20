package com.fullness.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/admin/product-add")
    public String input() {
        return "admin/product-add";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute("newItemForm") NewItemForm newItemForm, Model model) {
        model.addAttribute("newItemForm", newItemForm);
        return "admin/product/add/confirm";
    }
}
