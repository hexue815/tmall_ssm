package com.xue.service.impl;

import com.xue.mapper.CategoryMapper;
import com.xue.pojo.Category;
import com.xue.service.CategoryService;
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
    public List<Category> list() {
        return categoryMapper.list();
    }
}
