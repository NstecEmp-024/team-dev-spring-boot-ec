package com.fullness.ec.helper;

import com.fullness.ec.entity.Product;
import com.fullness.ec.form.NewItemForm;

public class NewItemHelper {
    public static Product convert(NewItemForm newItemForm) {
        Product product = new Product();
        product.setId(newItemForm.getId());
        product.setCategoryId(newItemForm.getCategoryId());
        product.setName(newItemForm.getName());
        product.setPrice(newItemForm.getPrice());
        product.setAmount(newItemForm.getAmount());
        product.setImage("");
        return product;
    }
}