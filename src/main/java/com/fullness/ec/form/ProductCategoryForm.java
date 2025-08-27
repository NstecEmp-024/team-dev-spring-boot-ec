package com.fullness.ec.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCategoryForm {
    @Size(min = 2, max = 20)
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-００-９]*$")
    private String categoryName;// 新商品カテゴリ名
}