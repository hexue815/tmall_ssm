package com.xue.mapper;

import com.xue.pojo.Category;
import com.xue.utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<Category> list(Page page);

    List<Category> listByPageHelper();

    public int total();

    int add(Category category);

    int delete(@Param("id") int id);

    Category getCategoryByID(@Param("id") int id);

    int update(Category category);
}
