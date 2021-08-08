package com.xue.service.impl;

import com.xue.mapper.ProductMapper;
import com.xue.pojo.Category;
import com.xue.pojo.Product;
import com.xue.pojo.ProductImage;
import com.xue.service.ProductImageService;
import com.xue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public void fill(List<Category> categories) {
        for (Category c : categories) {
            fill(c);
        }
    }

    @Override
    public void fill(Category category) {
        List<Product> products = getProductsByCid(category.getId());
        category.setProducts(products);
    }

    @Override
    public void fillByRow(List<Category> categories) {
        // 把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
        int productNumberEachRow = 8;
        for (Category c :
                categories) {
            List<Product> products = c.getProducts();
            List<List<Product>> productsByRow = new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i + productNumberEachRow;
                size = size >products.size()?products.size():size;
                List<Product> productsofEachRow = products.subList(i,size);
                productsByRow.add(productsofEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }


}
