package com.bellar.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//做真实的图片的保存工作同时将生成的新的图片的名字保存到数据库当中去
public class MyUploadFileUtil {
public List<String> refileName(MultipartFile[] files) {
	List<String> imglist=new ArrayList<>();
	MyProperty myProperty = new MyProperty();
	String property = myProperty.getProperty("windows_path");
	String newfileName=null;
for (MultipartFile file : files) {
String realfliename = file.getOriginalFilename();
newfileName=System.currentTimeMillis()+realfliename;
//如果报错就看一下错误的提示小括号里面的做错的话一般都是传递的参数的错误
try {
	file.transferTo(new File(property+"\\"+newfileName));
} catch (IllegalStateException | IOException e) {
	e.printStackTrace();
}
imglist.add(newfileName);
}
return imglist;
}
}
