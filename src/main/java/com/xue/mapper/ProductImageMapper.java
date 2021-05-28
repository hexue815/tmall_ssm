package com.xue.mapper;

import com.xue.pojo.ProductImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductImageMapper {
    int deleteProductImageByID(@Param("id") int id);

    int insert(ProductImage productImage);

    ProductImage selectProductImageByID(@Param("id") int id);

    List<ProductImage> selectProductImages();

    int updateProductImage(ProductImage productImage);

    List<ProductImage> selectProductImageByPid(@Param("pid") int pid);

    List<ProductImage> list(Map<String, Object> map);
}
