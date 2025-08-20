package com.fullness.ec.form;

import lombok.Data;

//入力された商品を格納するFormオブジェクト
@Data
public class NewItemForm {
    private Integer id; // 商品ID
    private Integer categoryId; // 商品カテゴリID
    private String name; // 商品名
    private Integer price; // 価格
    private String image; // 商品画像URL
}
