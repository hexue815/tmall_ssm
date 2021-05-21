package com.xue.service.impl;

import com.xue.mapper.CategoryMapper;
import com.xue.pojo.Category;
import com.xue.service.CategoryService;
import com.xue.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    @Qualifier("categoryMapper")
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> list(Page page) {
        return categoryMapper.list(page);
    }

    @Override
    public List<Category> listByPageHelper() {
        return categoryMapper.listByPageHelper();
    }

    @Override
    public int total() {
        return categoryMapper.total();
    }

    @Override
    public int add(Category category) {
        return categoryMapper.add(category);
    }

    @Override
    public int delete(int id) {
        return categoryMapper.delete(id);
    }

    @Override
    public Category getCategoryByID(int id) {
        return categoryMapper.getCategoryByID(id);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }
}
