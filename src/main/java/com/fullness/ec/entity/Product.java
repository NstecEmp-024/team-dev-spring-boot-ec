package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id; //商品ID
    private Integer categoryId; //商品カテゴリID
    private String name; //商品名
    private Integer price; //価格
    private String image; //商品画像URL
    private boolean deleteFlag; //削除フラグ
}
