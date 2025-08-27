package com.fullness.ec.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fullness.ec.entity.Product;
import com.fullness.ec.form.NewItemForm;
import com.fullness.ec.helper.NewItemHelper;
import com.fullness.ec.repository.ProductRepository;

/**
 * 商品に関連した内部処理インタフェースの実装
 */
@Service // インスタンス生成対象であり、内部処理を行う
@Transactional // トランザクション制御を行う
public class ProductServiceImpl implements ProductService {
    // ProductRepositoryを利用してデータベースにアクセスする
    @Autowired
    private ProductRepository productRepository;

    /**
     * 商品ページ毎に取得する
     * 
     * @param pageable ページ情報
     * @return 商品一覧
     */

    @Override
    public Page<Product> findProductByPage(Pageable pageable, Integer categoryId) {
        // レコード数を取得する
        // trimで１つに
        Integer total;
        List<Product> products;
        // カテゴリIDが指定されていない場合は全商品を取得
        // カテゴリIDが指定されている場合はそのカテゴリの商品を取得

        if (categoryId == null || categoryId == 0) {

            products = productRepository.findAllProductsByPage(pageable);
            total = productRepository.countAll();

        } else {

            products = productRepository.findProductsByCategoryIdAndPage(pageable, categoryId);
            total = productRepository.countAllByCategoryId(categoryId);
        }

        // 取得したデータ、ページデータ。件数を返す
        return new PageImpl<>(products, pageable, total);
    }

    // /**
    // * 商品一覧を返す
    // * @return 商品一覧
    // */
    // @Transactional(readOnly = true)
    // @Override
    // public List<Product> getAllProducts(){
    // return productRepository.findAllProducts();
    // }

    // /**
    // * 商品検索（カテゴリ検索）を行う
    // * @param categoryId カテゴリID
    // */
    // @Transactional(readOnly = true)
    // @Override
    // public List<Product> findProductsByCategoryId(Integer categoryId){
    // return productRepository.findProductsByCategoryId(categoryId);
    // }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findProductsByCategoryId(Integer categoryId) {
        // カテゴリIDが指定されていない場合は全商品を取得
        // カテゴリIDが指定されている場合はそのカテゴリの商品を取得
        if (categoryId == null || categoryId == 0) {
            return productRepository.findAllProducts();
        } else {
            return productRepository.findProductsByCategoryId(categoryId);
        }

    }

    @Override
    public void addProduct(NewItemForm newItemForm) {
        Product product = NewItemHelper.convert(newItemForm);
        productRepository.insert(product);
    }

    @Override
    public List<Product> selectAll() {
        return productRepository.selectAll();
    }

}
