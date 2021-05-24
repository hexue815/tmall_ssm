package com.xue.service.impl;

import com.xue.mapper.ProductMapper;
import com.xue.pojo.Product;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productMapper")
    private ProductMapper productMapper;

    @Override
    public int insert(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public int delete(int id) {
        return productMapper.delete(id);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

    @Override
    public Product getProductByID(int id) {
        return productMapper.getProductByID(id);
    }

    @Override
    public List<Product> getProductsByCid(int cid) {
        return productMapper.getProductsByCid(cid);
    }
}
