package com.fullness.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullness.ec.service.ProductCategoryService;
import com.fullness.ec.service.ProductService;

@Controller
@RequestMapping("admin")
public class SearchProductController {
    @Autowired ProductCategoryService productCategoryService;
    @GetMapping("product")
    public String searchProductCategory(Model model){
        return "admin/product";
    }

}
