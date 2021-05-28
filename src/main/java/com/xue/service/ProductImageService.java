package com.xue.service;

import com.xue.pojo.ProductImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductImageService{
    String type_single = "type_single";
    String type_detail = "type_detail";

    int deleteProductImageByID(int id);

    int insert(ProductImage productImage);

    ProductImage selectProductImageByID(int id);

    List<ProductImage> selectProductImages();

    int updateProductImage(ProductImage productImage);

    List<ProductImage> selectProductImageByPid(int pid);

    List<ProductImage> list(Map<String, Object> map);
}
