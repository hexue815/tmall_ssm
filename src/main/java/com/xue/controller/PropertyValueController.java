package com.xue.controller;

import com.xue.pojo.Category;
import com.xue.pojo.Product;
import com.xue.pojo.PropertyValue;
import com.xue.service.CategoryService;
import com.xue.service.ProductService;
import com.xue.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;
    @Autowired
    @Qualifier("propertyValueServiceImpl")
    private PropertyValueService propertyValueService;
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(@RequestParam("pid") int pid, Model model){
        //产品对象引用用于面包屑导航
        Product product = productService.getProductByID(pid);
        Category category = categoryService.getCategoryByID(product.getCid());
        //初始化
        propertyValueService.init(product);
        List<PropertyValue> pvs = propertyValueService.getPropertyValues(product.getId());
        model.addAttribute("product", product);
        model.addAttribute("pvs", pvs);
        model.addAttribute("category", category);
        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue propertyValue){
        propertyValueService.update(propertyValue);
        return "success";
    }
}
