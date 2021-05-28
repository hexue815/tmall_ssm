package com.xue.service.impl;

import com.xue.mapper.ProductImageMapper;
import com.xue.pojo.ProductImage;
import com.xue.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    @Qualifier("productImageMapper")
    private ProductImageMapper productImageMapper;
    @Override
    public int deleteProductImageByID(int id) {
        return productImageMapper.deleteProductImageByID(id);
    }

    @Override
    public int insert(ProductImage productImage) {
        return productImageMapper.insert(productImage);
    }

    @Override
    public ProductImage selectProductImageByID(int id) {
        return productImageMapper.selectProductImageByID(id);
    }

    @Override
    public List<ProductImage> selectProductImages() {
        return productImageMapper.selectProductImages();
    }

    @Override
    public int updateProductImage(ProductImage productImage) {
        return productImageMapper.updateProductImage(productImage);
    }

    @Override
    public List<ProductImage> selectProductImageByPid(int pid) {
        return productImageMapper.selectProductImageByPid(pid);
    }

    @Override
    public List<ProductImage> list(Map<String, Object> map) {
        return productImageMapper.list(map);
    }
}
