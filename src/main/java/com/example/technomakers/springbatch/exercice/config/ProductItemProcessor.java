package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Product;
import org.springframework.batch.item.ItemProcessor;


public class ProductItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product product) {
        if(product.getQuantityInStock()<=30)
            product.setQuantityInStock(product.getQuantityInStock()+10);
        return product;
    }
}
