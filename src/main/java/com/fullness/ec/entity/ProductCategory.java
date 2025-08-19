package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    Integer  categoryId; // 商品カテゴリID
    String categoryName; // 商品カテゴリ名
}
