package com.fullness.ec.helper;

import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.form.ProductCategoryForm;

public class ProductCategoryHelper {
    public static ProductCategory convert(ProductCategoryForm categoryForm) {
        ProductCategory category = new ProductCategory();
        category.setCategoryName(categoryForm.getCategoryName());
        return category;
    }
}
