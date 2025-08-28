package com.fullness.ec.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Product;
import com.fullness.ec.form.NewItemForm;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    // 全商品一覧をページ毎に取得するメソッドのテスト

    @Transactional
    @Test
    void testFindProductByPage_findAllProducts_CategoryId_null() {
        // テストの実装
        // カテゴリIDがnullの場合、全商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = null; // カテゴリIDはnullで全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);

        // 期待される結果を検証
        assertEquals(10, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(3, productsPage.getTotalPages()); // 総ページ数
        assertEquals(25, productsPage.getTotalElements()); // 総件数
        assertEquals("水性ボールペン(黒)", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("蛍光ペン(緑)", productsPage.getContent().get(9).getName()); // ソート順による10番目

    }

    // 取得したカテゴリIDに基づいて商品一覧をページ毎に取得するメソッドのテスト
    @Transactional
    @Test
    void testFindProductByPage_findProductsByCategoryId_0() {
        // テストの実装
        // カテゴリIDが0の場合、全商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = 0; // カテゴリIDは0で全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);

        // 期待される結果を検証
        assertEquals(10, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(3, productsPage.getTotalPages()); // 総ページ数
        assertEquals(25, productsPage.getTotalElements()); // 総件数
        assertEquals("水性ボールペン(黒)", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("蛍光ペン(緑)", productsPage.getContent().get(9).getName()); // ソート順による10番目
    }

    // 商品IDを指定して商品情報を取得するメソッドのテスト
    @Transactional
    @Test
    void testFindProductByPage_findProductsByCategoryId_2() {
        // テストの実装
        // カテゴリIDが2の場合、全雑貨商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = 2; // カテゴリIDは2で全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);

        // 期待される結果を検証
        assertEquals(5, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(1, productsPage.getTotalPages()); // 総ページ数
        assertEquals(5, productsPage.getTotalElements()); // 総件数
        assertEquals("ワンタッチ開閉傘", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("キーホルダ", productsPage.getContent().get(3).getName()); // ソート順による先頭

    }

    @Transactional
    @Test
    void testAddProduct() {
        // テストの実装
        NewItemForm newItemForm = new NewItemForm();
        newItemForm.setName("テストボールペン");
        newItemForm.setPrice(500);
        newItemForm.setAmount(100);
        newItemForm.setCategoryId(1);
        newItemForm.setImage(null);

        productService.addProduct(newItemForm);
        List<Product> result = productService.selectAll();
        assertEquals(26, result.size());
    }
}
