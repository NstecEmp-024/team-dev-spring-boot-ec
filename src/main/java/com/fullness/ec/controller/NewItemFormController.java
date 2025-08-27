package com.fullness.ec.controller;

import java.io.IOException;
import com.fullness.ec.service.ProductCategoryServiceImpl;
import com.fullness.ec.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullness.ec.service.ProductCategoryService;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.form.NewItemForm;
import com.fullness.ec.helper.ImageUploadHelper;
import com.fullness.ec.helper.NewItemHelper;

@Controller
@RequestMapping("/admin")
@SessionAttributes("newItemForm")
public class NewItemFormController {

    private final ProductCategoryServiceImpl productCategoryServiceImpl;

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;

    NewItemFormController(ProductCategoryServiceImpl productCategoryServiceImpl) {
        this.productCategoryServiceImpl = productCategoryServiceImpl;
    }

    @ModelAttribute("newItemForm")
    public NewItemForm setupForm() {
        return new NewItemForm();
    }

    @GetMapping("/product-add")
    public String input(Model model) {
        model.addAttribute("categoryList", productCategoryService.getAllProductCategories());
        return "admin/product-add";
    }

    @PostMapping("/confirm")
    public String confirm(@Validated @ModelAttribute("newItemForm") NewItemForm newItemForm,
            BindingResult bindingResult, Model model) {

        ProductCategory productCategory = null;
        for (ProductCategory category : productCategoryService.getAllProductCategories()) {
            if (category.getCategoryId().equals(newItemForm.getCategoryId())) {
                productCategory = category;
                break;
            }
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", productCategoryService.getAllProductCategories());
            return "admin/product-add";
        }

        model.addAttribute("productCategory", productCategory);
        model.addAttribute("newItemForm", newItemForm);
        // model.addAttribute("imageByte", newItemForm.getFile().getBytes());
        // model.addAttribute("image",
        // ImageUploadHelper.createBase64ImageString(newItemForm.getFile()));

        return "admin/product/add/confirm";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute("newItemForm") NewItemForm newItemForm,
            RedirectAttributes redirectAttributes) {
        productService.addProduct(newItemForm);
        redirectAttributes.addFlashAttribute("newItemForm", newItemForm);
        return "redirect:/admin/complete";
    }

    @GetMapping("/complete")
    public String complete(@ModelAttribute("newItemFormFlash") NewItemForm newItemForm, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "admin/product/add/complete";
    }

}
