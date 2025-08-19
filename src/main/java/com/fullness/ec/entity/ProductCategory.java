package com.fullness.ec.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    private Integer  categoryId; // 商品カテゴリID
    private String categoryName; // 商品カテゴリ名
    private List<Product> products; // 取得してきた商品データを格納するリスト
}
