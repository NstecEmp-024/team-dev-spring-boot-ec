package com.fullness.ec.controller;

import java.util.Locale.Category;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("admin/category/add") // 
@SessionAttributes({"categoryForm"})
public class CategoryController {

    // カテゴリ登録画面へ遷移する
    @GetMapping("input")
    public String input(Model model) {
        return "category/add/input"; // category/add/input.htmlを返す 

    }

        /**
     * 入力画面の[完了]ボタンクリック
     * @param form
     * @param result
     * @param model
     * @return
     */
    @PostMapping("confirm")
    public String confirm(@Validated CategoryForm form , BindingResult result , Model model) {
        if (result.hasErrors()){ // バリデーションエラーあり
            // 入力画面に遷移する
            return "category/add/input";
        }
        // 確認画面に遷移する
        return "category/add/confirm";
    }
    
    /**** PRGパターン開始 ****/
    /**
     * 確認画面の[登録]ボタンクリック
     * @param form
     * @return
     */
    @PostMapping("register")
    public String register(CategoryForm form , RedirectAttributes ra){
        Category category = categoryHelper.convert(form);
        categoryService.register(category);
        ra.addFlashAttribute("completed", true);
        return "redirect:/admin/category/add/complete";
    }
    /**
     * リダイレクトされたリクエストへの応答
     * @param form
     * @param status
     * @param model 
     * @return
     */
    @GetMapping("complete")
    public String getMethodName(CategoryForm form,SessionStatus status,Model model) {
        if (!model.containsAttribute("completed")) {
            return "redirect:/admin/category/add/input";
        }
        model.addAttribute("addCategoryId", form.getId());
        // セッションをクリアする
        status.setComplete();
        // 完了画面に遷移する
        return "category/add/complete";
    }
    /**** PRGパターン終了 ****/


    /**
     * 確認画面の[戻る]ボタンクリック
     * @return
     */
    @PostMapping("back")
    public String back() {
        return "redirect:/admin/category/add/input";
    }

   

}
