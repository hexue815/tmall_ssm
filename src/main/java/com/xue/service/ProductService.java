package com.xue.service;

import com.xue.pojo.Product;

import java.util.List;

public interface ProductService {
    int insert(Product product);

    int delete(int id);

    int update(Product product);

    List<Product> getProducts();

    Product getProductByID(int id);

    List<Product> getProductsByCid(int cid);

    void setFirstProductImage(Product product);
}
