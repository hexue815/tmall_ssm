package com.xue.mapper;

import com.xue.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int insert(Product product);

    int delete(@Param("id") int id);

    int update(Product product);

    List<Product> getProducts();

    Product getProductByID(@Param("id") int id);

    List<Product> getProductsByCid(@Param("cid") int cid);
}
