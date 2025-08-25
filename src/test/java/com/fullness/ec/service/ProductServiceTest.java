package com.fullness.ec.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fullness.ec.entity.Product;


@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    // 全商品一覧をページ毎に取得するメソッドのテスト 

    @Test
    void testFindProductByPage_findAllProducts_CategoryId_null() {
        // テストの実装
        // カテゴリIDがnullの場合、全商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = null; // カテゴリIDはnullで全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);
        
        // 期待される結果を検証
        assertEquals(10, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(0, productsPage.getNumber()); // ページ番号
        assertEquals(3, productsPage.getTotalPages()); // 総ページ数
        assertEquals(24, productsPage.getTotalElements()); // 総件数
        assertEquals("水性ボールペン(黒)", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("蛍光ペン(緑)", productsPage.getContent().get(9).getName()); // ソート順による10番目




    }

    // 取得したカテゴリIDに基づいて商品一覧をページ毎に取得するメソッドのテスト
    @Test
    void testFindProductByPage_findProductsByCategoryId_0() {
       // テストの実装
        // カテゴリIDが0の場合、全商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = 0; // カテゴリIDは0で全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);
        
        // 期待される結果を検証
        assertEquals(10, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(0, productsPage.getNumber()); // ページ番号
        assertEquals(3, productsPage.getTotalPages()); // 総ページ数
        assertEquals(24, productsPage.getTotalElements()); // 総件数
        assertEquals("水性ボールペン(黒)", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("蛍光ペン(緑)", productsPage.getContent().get(9).getName()); // ソート順による10番目
    } 
    
    // 商品IDを指定して商品情報を取得するメソッドのテスト
    @Test
    void testFindProductByPage_findProductsByCategoryId_2() {
       // テストの実装
        // カテゴリIDが2の場合、全雑貨商品を取得するメソッドをテスト
        Pageable pageable = PageRequest.of(0, 10); // 1ページ目、10件

        Integer categoryId = 2; // カテゴリIDは2で全商品を取得

        Page<Product> productsPage = productService.findProductByPage(pageable, categoryId);
        
        // 期待される結果を検証
        assertEquals(4, productsPage.getContent().size()); // 実際に取得された件数
        assertEquals(0, productsPage.getNumber()); // ページ番号
        assertEquals(1, productsPage.getTotalPages()); // 総ページ数
        assertEquals(4, productsPage.getTotalElements()); // 総件数
        assertEquals("ワンタッチ開閉傘", productsPage.getContent().get(0).getName()); // ソート順による先頭
        assertEquals("キーホルダ", productsPage.getContent().get(3).getName()); // ソート順による先頭

    }
}
