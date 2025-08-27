package com.fullness.ec.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.fullness.ec.form.ProductCategoryForm;
import com.fullness.ec.helper.ProductCategoryHelper;
import com.fullness.ec.service.ProductCategoryService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
@RequestMapping("/admin")
@SessionAttributes("categoryForm")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService categoryService;
    @ModelAttribute("categoryForm")
    public ProductCategoryForm setupForm() {
        return new ProductCategoryForm();
    }
    @GetMapping("/product-category-add")
    public String input() {
        return "admin/product-category-add/product-category-add";
    }
    @PostMapping("/product-category-add/confirm")
    public String confirm(@Validated @ModelAttribute("categoryForm") ProductCategoryForm categoryForm,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/product-category-add/product-category-add";
        }
        model.addAttribute("categoryForm", categoryForm);
        return "admin/product-category-add/confirm";
    }
    @PostMapping("/product-category-add/register")
    public String register(@ModelAttribute("categoryForm") ProductCategoryForm categoryForm, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        // 商品カテゴリ名の重複チェック
        if (categoryService.existCategory(categoryForm.getCategoryName())) {
            bindingResult.rejectValue("categoryName", "error.categoryForm.categoryName", "この商品カテゴリ名はすでに存在します。");
        }
        // バリデーションエラーがあれば入力画面に戻す
        if (bindingResult.hasErrors()) {
            return "admin/product-category-add/product-category-add";
        }
        // DB登録
        categoryService.addCategory(ProductCategoryHelper.convert(categoryForm));
        // 登録完了後、リダイレクトしてフラッシュスコープにデータを保存
        redirectAttributes.addFlashAttribute("categoryFormFlash", categoryForm);
        return "redirect:complete";
    }
    @GetMapping("/product-category-add/complete")
    public String complete(@ModelAttribute("categoryFormFlash") ProductCategoryForm categoryForm,
            SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "admin/product-category-add/complete";
    }
}