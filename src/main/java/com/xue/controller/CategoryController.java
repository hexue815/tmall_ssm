package com.xue.controller;

import com.xue.pojo.Category;
import com.xue.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;
    @RequestMapping("admin_category_list")
    public String list(Model model){
        List<Category> categories = categoryService.list();
        model.addAttribute("categories", categories);
        return "admin/listCategory";
    }
}
