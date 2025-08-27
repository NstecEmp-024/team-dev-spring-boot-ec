package com.fullness.ec.form;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

//入力された商品を格納するFormオブジェクト
@Data
public class NewItemForm implements Serializable {
    private Integer id; // 商品ID
    private Integer categoryId; // 商品カテゴリID
    @Size(min = 2, max = 22)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-００-９]*$")
    private String name; // 商品名

    @Max(1000000)
    @NotNull
    @Positive
    private Integer price; // 価格

    @Max(1000)
    @NotNull
    @Positive
    private Integer amount; // 在庫数

    // @NotNull
    private List<String> options; // プルダウンで選択した商品カテゴリ
    // @NotNull
    private String image; // 商品画像URL
    // private MultipartFile file;// 画像ファイル
}
