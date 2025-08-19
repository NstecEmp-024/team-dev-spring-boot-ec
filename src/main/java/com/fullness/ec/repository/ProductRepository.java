package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import com.fullness.ec.entity.Product;

@Mapper
public interface ProductRepository {
    List<Product> findAllProducts();

    /**
     * 指定されたカテゴリIDに属する商品の取得
     * @param categoryId カテゴリID
     * @return 指定されたカテゴリに属する商品のリスト
     */
    List<Product> findProductsByCategoryId(Integer categoryId);

     /**
     * 商品テーブルのレコード件数を取得
     * @return
     */
    Integer countAll();

    /**
     * 1ページ分の表示データを取得する
     * @param pageable //1ページ分のデータ
     * @return 1ページ分の表示データ
     */
    List<Product> findAllProductsByPage(@Param("pageable") Pageable pageable);
    
    
}
