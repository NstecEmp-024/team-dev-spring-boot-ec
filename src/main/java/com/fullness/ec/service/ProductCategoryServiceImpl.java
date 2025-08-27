package com.fullness.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.repository.ProductCategoryRepository;

/**
 * 商品カテゴリに関連した内部処理インタフェースの実装
 */
@Service // インスタンス生成対象であり、内部処理を行う
@Transactional // トランザクション制御を行う
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ProductCategoryRepository categoryRepository;
    /**
     * 商品カテゴリ一覧を取得する
     * @return 商品カテゴリ一覧
     */
    @Transactional(readOnly = true)
    @Override
    public List<ProductCategory> getAllProductCategories(){
        return productCategoryRepository.findAllCategories();
    }

    @Override
    public void addCategory(ProductCategory productCategory) {
        // 商品カテゴリを追加する
        categoryRepository.insert(productCategory);
    }
    @Override
    public boolean existCategory(String categoryName) {
        // 商品カテゴリ名で検索して存在チェック
        List<ProductCategory> categories = categoryRepository.selectByName(categoryName);
        return !categories.isEmpty();
    }
    
}
