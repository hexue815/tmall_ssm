package com.xue.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xue.pojo.Category;
import com.xue.pojo.Product;
import com.xue.service.CategoryService;
import com.xue.service.ProductService;
import com.xue.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;
    @Autowired
    @Qualifier("productServiceImpl")
    private ProductService productService;


    @RequestMapping("admin_product_list")
    public String list(@RequestParam("cid") int cid, Model model, Page page){
        Category category = categoryService.getCategoryByID(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> products = productService.getProductsByCid(cid);
        int total = (int) new PageInfo<>(products).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + category.getId());
        model.addAttribute("products", products);
        model.addAttribute("category", category);
        model.addAttribute("page", page);
        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String add(Product product){
        productService.insert(product);
        product.setCreateDate(new Date());
        return "redirect:admin_product_list?cid=" + product.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(@RequestParam("id") int id){
        Product product = productService.getProductByID(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid=" + product.getCid();
    }
}





























