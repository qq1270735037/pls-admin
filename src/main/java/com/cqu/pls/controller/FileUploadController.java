package com.cqu.pls.controller;


import java.text.SimpleDateFormat;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import  java.util.Date;
/**
 * 文件上传，得到url
 * "http://localhost:8080/2022/06/30/c26e0cd7-ceff-4b77-bc4e-c850e6172fac.png"
 */
@RestController
@RequestMapping("fileupload")
public class FileUploadController {
//    private final String storageUrl="http://159.75.38.129:9000";
//    private final String storageAccessKey="jN0IHFLCIFltCDYI";
//    private final String storageSecretKey="Be95DutMH0M3fyUVSzC9Kul0hnwSFCD1";
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @PostMapping("add")
    public String test(MultipartFile file, HttpServletRequest req) throws IOException {
        String format = sdf.format(new Date());
        System.out.println();
        String realPath = req.getServletContext().getRealPath("/") + format;
        System.out.println(realPath);
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        String name = file.getOriginalFilename();
        System.out.println(file.getContentType());
        String newName = UUID.randomUUID().toString();
        if(file.getContentType().equals("image/jpeg")){
//            System.out.println("这是jpg");
            newName += ".jpg";
        }else { //png图片
            newName += ".png";
        }
        System.out.println("新的文件名");
        System.out.println(folder);
        System.out.println(newName);
        file.transferTo(new File(folder,newName));
        String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+format+newName;
        System.out.println(url);
        return url;
    }
}
