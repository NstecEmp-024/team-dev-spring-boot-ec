package com.fullness.ec.service;

import java.util.List;

import com.fullness.ec.entity.ProductCategory;

public interface ProductCategoryService {
    /**
     * 商品カテゴリ一覧を表示する
     * 
     * @return 商品カテゴリ一覧
     */
    List<ProductCategory> getAllProductCategories();

    void addCategory(ProductCategory productCategory);

    boolean existCategory(String categoryName);

}
