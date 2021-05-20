package com.xue.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadedImageFile {
    /*
    * 用于接受上传文件的注入
    * 属性名称image必须和页面<type="file"的name值保持一致
    * */
    MultipartFile image;
}
