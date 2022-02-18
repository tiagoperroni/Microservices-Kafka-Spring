package com.tiagoperroni.order.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tiagoperroni.order.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {    

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        var product1 = new Product(1, "Garoto Cola", 100, 7.95);
        var product2 = new Product(2, "Garoto Fanta", 100, 6.95);
        var product3 = new Product(3, "Garoto Uva", 100, 6.87);
        var product4 = new Product(4, "Garoto Franboesa", 100, 7.10);
        products.addAll(Arrays.asList(product1, product2, product3, product4));
        return products;
    }

    public Product findById(Integer id) {
        for (Product product : this.getAll()) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }


    
}
