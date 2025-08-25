package com.fullness.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fullness.ec.entity.Product;
import com.fullness.ec.service.ProductCategoryService;
import com.fullness.ec.service.ProductService;

//@SessionAttributes({"", "productCategoryList"})
@Controller
@RequestMapping("/admin")
public class SearchProductController {
    @Autowired 
    ProductCategoryService productCategoryService;

    @Autowired 
    ProductService productService;
    /**
     * 商品検索（カテゴリ検索）を行う
     * @param pageable ページ情報
     * @param categoryId カテゴリID
     * @param model モデル
     * @return 商品一覧ページ
     */
    
    @GetMapping("/product")
    public String searchProductCategory(@PageableDefault(page=0, size=10)Pageable pageable, 
    @RequestParam(name = "categoryId", required = false) Integer categoryId,
     Model model){

        
        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);

        //URLの取得
        model.addAttribute("pageUrl", "/admin/product?");

        // 商品情報の取得
        model.addAttribute("productsPage",productsPage); 

        // ページネーション 
        model.addAttribute("next",pageable.getPageNumber()+2);
        model.addAttribute("prev",pageable.getPageNumber());

        // 商品カテゴリ一覧を取得してモデルに追加
        model.addAttribute("productCategoryList", 
        productCategoryService.getAllProductCategories());
        // 選択したカテゴリIDを格納
        //三項演算子でnullnの場合は空文字を設定
        // model.addAttribute("selectCategoryId", categoryId == null ? "" : categoryId);
        model.addAttribute("selectCategoryId", categoryId == null ? "" : categoryId);


        // Serviceクラスで取得してきたデータをProductsに格納する
        // List<Product> products = productService.findProductsByCategoryId(categoryId);
        // model.addAttribute("products", products);
        
        // System.out.println("選択したカテゴリID: " + categoryId);

        return "admin/product";
    }

}
