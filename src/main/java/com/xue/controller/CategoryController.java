package com.xue.controller;

import com.xue.pojo.Category;
import com.xue.service.CategoryService;
import com.xue.utils.ImageUtil;
import com.xue.utils.Page;
import com.xue.utils.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        List<Category> categories = categoryService.list(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("categories", categories);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

    /*
    * @category用于接收页面传来的name
    * */
    @RequestMapping("admin_category_add")
    public String add(Category category, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.add(category);
        //通过Session获取ControllerContext，再通过getRealPath定位存放分类图片的路径
        File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
        //根据ID创建文件名
        File file = new File(imageFolder, category.getId() + ".jpg");
        // 如果/img/category目录不存在，则创建该目录，否则后续保存浏览器传过来图片，会提示无法保存
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        // 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
        uploadedImageFile.getImage().transferTo(file);
        // 通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
        BufferedImage image = ImageUtil.change2jpg(file);
        //重新写入图片
        ImageIO.write(image, "jpg", file);

        return "redirect:/admin_category_list";
    }

    /*
    * 删除Category
    *
    * */
    @RequestMapping("admin_category_delete")
    public String delete(int id){

        return "";
    }
}

























