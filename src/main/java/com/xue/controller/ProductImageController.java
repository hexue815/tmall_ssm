package com.xue.controller;

import com.xue.pojo.Product;
import com.xue.pojo.ProductImage;
import com.xue.service.ProductImageService;
import com.xue.service.ProductService;
import com.xue.utils.ImageUtil;
import com.xue.utils.UploadedImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private ProductService productService;

    @RequestMapping("admin_productImage_list")
    public String list(@RequestParam("pid") int pid, Model model){
        Product product = productService.getProductByID(pid);
        HashMap<String, Object> map_single = new HashMap<>();
        HashMap<String, Object> map_detail = new HashMap<>();
        map_single.put("pid", pid);
        map_detail.put("pid", pid);
        map_single.put("type", productImageService.type_single);
        map_detail.put("type", productImageService.type_detail);
        List<ProductImage> productImagesSingles = productImageService.list(map_single);
        List<ProductImage> productImagesDetails = productImageService.list(map_detail);

        model.addAttribute("product", product);
        model.addAttribute("productImagesSingles", productImagesSingles);
        model.addAttribute("productImagesDetails", productImagesDetails);
        return "admin/listProductImage";
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(@RequestParam("id") int id, HttpSession session){
        ProductImage productImage = productImageService.selectProductImageByID(id);
        String fileName = id + "jpg";
        String imageFolder;
        String imageFolder_small;
        String imageFolder_middle;

        if (productImageService.type_single.equals(productImage.getType())){
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small = session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle_middle");

            File imageFile = new File(imageFolder, fileName);
            File file_small = new File(imageFolder_small, fileName);
            File file_middle = new File(imageFolder_middle, fileName);
            imageFile.delete();
            file_small.delete();
            file_middle.delete();
        }else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder, fileName);
            imageFile.delete();
        }

        productImageService.deleteProductImageByID(id);
        return "redirect:admin_productImage_list?pid=" + productImage.getPid();
    }

    @RequestMapping("admin_productImage_add")
    public String add(ProductImage productImage, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        productImageService.insert(productImage);
        //????????????
        String fileName = productImage.getId() + ".jpg";
        //?????????????????????
        String imageFolder;
        String imageFolder_small = null;
        String imageFolder_middle = null;
        //???????????????????????????????????????
        if (productImageService.type_single.equals(productImage.getType())){
            imageFolder = session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small = session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle = session.getServletContext().getRealPath("img/productSingle_middle");
        }else {
            imageFolder = session.getServletContext().getRealPath("img/productDetail");
        }
        //????????????
        File file = new File(imageFolder, fileName);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        //???????????????????????????????????????????????????????????????
        uploadedImageFile.getImage().transferTo(file);
        //??????????????????jpg
        BufferedImage bufferedImage = ImageUtil.change2jpg(file);
        //???????????????jpg??????????????????file???
        ImageIO.write(bufferedImage,"jpg",file);
        //?????????????????????????????????????????????????????????
        if (ProductImageService.type_single.equals(productImage.getType())){
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            ImageUtil.resizeImage(file, 56, 56, f_small);
            ImageUtil.resizeImage(file, 217, 190, f_middle);
        }
        return "redirect:admin_productImage_list?pid=" + productImage.getPid();
    }

}






























