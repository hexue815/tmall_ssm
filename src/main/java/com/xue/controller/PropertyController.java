package com.xue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.pojo.Category;
import com.xue.pojo.Property;
import com.xue.service.CategoryService;
import com.xue.service.PropertyService;
import com.xue.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    @Qualifier("propertyServiceImpl")
    private PropertyService propertyService;
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping("admin_property_list")
    public String list(@RequestParam("cid") int cid, Model model, Page page){
        Category category = categoryService.getCategoryByID(cid);

        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Property> properties = propertyService.list(cid);

        int total = (int) new PageInfo<>(properties).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + category.getId());
        model.addAttribute("properties", properties);
        model.addAttribute("category", category);
        model.addAttribute("page", page);

        return "admin/listProperty";
    }
}

































