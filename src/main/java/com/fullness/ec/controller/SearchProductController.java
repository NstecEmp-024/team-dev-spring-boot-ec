package com.fullness.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fullness.ec.service.ProductCategoryService;
import com.fullness.ec.service.ProductService;

@Controller
@RequestMapping("admin")
public class SearchProductController {
    @Autowired ProductCategoryService productCategoryService;
    @Autowired ProductService productService;
    @GetMapping("product")
    public String searchProductCategory(@RequestParam ("categoryId") Integer categoryId,
    Model model){
        // 商品カテゴリ一覧を取得してモデルに追加
        model.addAttribute("productCategories", productCategoryService.getAllProductCategories());
        // // 商品一覧を取得してモデルに追加
        // model.addAttribute("products", productService.getAllProducts()); 
        // カテゴリ検索で商品一覧を表示する
        model.addAttribute("productsByProductCategory", productService.findProductsByCategoryId(categoryId));  
        return "admin/product";
    }

}
