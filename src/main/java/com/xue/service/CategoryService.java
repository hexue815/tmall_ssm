package com.xue.service;

import com.xue.pojo.Category;
import com.xue.utils.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list(Page page);

    int total();

    int add(Category category);

    int delete(int id);

    Category getCategoryByID(int id);

    int update(Category category);
}
