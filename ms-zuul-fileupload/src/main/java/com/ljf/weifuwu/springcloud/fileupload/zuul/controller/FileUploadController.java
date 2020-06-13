package com.ljf.weifuwu.springcloud.fileupload.zuul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

 /**
    * 上传文件
    * ps.该示例比较简单，没有做IO异常、文件大小、文件非空等处理
    * @param file 待上传的文件
    * @return 文件在服务器上的绝对路径
    * @throws IOException IO异常
    */
 @RequestMapping(value = "/zuul-Upload", method = RequestMethod.POST)
 public @ResponseBody String handleFileUpload(@RequestParam(value = "zuulFile", required = true) MultipartFile file) throws IOException {
     System.out.println("上传功能，controller!!!!");
     byte[] bytes = file.getBytes();
     File fileToSave = new File(file.getOriginalFilename());
     FileCopyUtils.copy(bytes, fileToSave);
     System.out.println("文件上传存储路径:"+fileToSave.getAbsolutePath());
     return fileToSave.getAbsolutePath();
 }


}
