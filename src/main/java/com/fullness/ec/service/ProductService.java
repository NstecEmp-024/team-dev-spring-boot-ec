package com.fullness.ec.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.fullness.ec.entity.Product;
import com.fullness.ec.form.NewItemForm;

/**
 * 商品に関連した内部処理インタフェース
 */
public interface ProductService {

  /**
   * 1ページ分の商品データを取得
   * 
   * @param pageable ページ情報
   * @return 商品データのページ
   */
  Page<Product> findProductByPage(Pageable pageable, Integer categoryId);

  // /**
  // * 商品一覧を表示する
  // * @return 商品一覧
  // */
  // List<Product> getAllProducts();

  /**
   * 商品検索（カテゴリ検索）
   */
  List<Product> findProductsByCategoryId(Integer categoryId);

  void addProduct(NewItemForm newItemForm);

  List<Product> selectAll();

}
