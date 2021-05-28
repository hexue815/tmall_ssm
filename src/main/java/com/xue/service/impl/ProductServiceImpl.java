package com.xue.service.impl;

import com.xue.mapper.ProductMapper;
import com.xue.pojo.Product;
import com.xue.pojo.ProductImage;
import com.xue.service.ProductImageService;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductImageService productImageService;

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

    @Override
    public void setFirstProductImage(Product product) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("pid", product.getId());
        map.put("type", productImageService.type_single);
        List<ProductImage> images = productImageService.list(map);
        if (!images.isEmpty()){
            ProductImage productImage = images.get(0);
            product.setFirstProductImage(productImage);
        }
    }


}
