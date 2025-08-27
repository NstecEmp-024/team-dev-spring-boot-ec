package com.fullness.ec.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.repository.ProductCategoryRepository;

@SpringBootTest
public class ProductCategoryServiceTest {
    @Autowired 
    ProductCategoryService productCategoryService;
    
    @Autowired 
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryService categoryService;
    
    // カテゴリ取得のテストクラス
    // ここでは、ProductCategoryServiceのメソッドをテストするためのコードを記述します。
    @Test
    void testFindAllCategories() {
        // テストの実装
        // ここでは、ProductCategoryServiceのfindAllCategoriesメソッドをテストするためのコードを記述します。
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();
        // 期待される結果を検証

        // カテゴリの数が3つであることを確認
        assertEquals(3, categories.size());

        // 取得したカテゴリ名が正しいことを確認
        assertEquals("文房具", categories.get(0).getCategoryName());
        assertEquals("雑貨", categories.get(1).getCategoryName());
        assertEquals("パソコン周辺機器", categories.get(2).getCategoryName());
        
    }
    @Transactional
    @Test // 新カテゴリ登録テスト
    public void testAddCategory() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("テストカテゴリ");
        categoryService.addCategory(category);
        assertEquals("テストカテゴリ", category.getCategoryName());
    }
    @Transactional
    @Test // カテゴリ重複チェックテスト（重複する場合）
    public void testExistCategory() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("文房具");
        boolean exists = categoryService.existCategory(category.getCategoryName());
        assertEquals(true, exists);
    }
    @Transactional
    @Test // カテゴリ重複チェックテスト(重複しない場合)
    public void testExistCategory2() {
        ProductCategory category = new ProductCategory();
        category.setCategoryName("テスト");
        boolean exists = categoryService.existCategory(category.getCategoryName());
        assertEquals(false, exists);
    }

}
