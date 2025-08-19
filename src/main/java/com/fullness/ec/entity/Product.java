package com.fullness.ec.entity;

import lombok.Data;

@Data
public class Product {
    Integer id; //商品ID
    Integer categoryId; //商品カテゴリID
    String name; //商品名
    Integer price; //価格
    String image; //商品画像URL
    boolean deleteFlag; //削除フラグ
}
