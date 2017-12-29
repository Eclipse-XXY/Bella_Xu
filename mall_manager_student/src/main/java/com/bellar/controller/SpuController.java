package com.bellar.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.bellar.bean.T_MALL_PRODUCT;
import com.bellar.service.SpuService;
import com.bellar.util.MyUploadFileUtil;

@Controller
public class SpuController {
	@Autowired
	SpuService spuServiceImpl;
@RequestMapping("/goto_spu")
	public String tospu(String success,ModelMap paramMap) {
	paramMap.put("success", success);
		return "manager_spu";
	}
@RequestMapping("/save_spu")
//一个参数的话不写value 也行 @RequestParam("files")需要指定一下因为框架的file类很多用于识别是哪一类的file文件
public Object dosave(T_MALL_PRODUCT spu,@RequestParam("files")MultipartFile[] files) {
	MyUploadFileUtil uploadFileUtil = new MyUploadFileUtil();
	//得到文件名的集合写入到数据库
	List<String> fileNamelist = uploadFileUtil.refileName(files);
   Boolean flag = spuServiceImpl.saveSpu(spu,fileNamelist);
   if (flag) {
	 //Spring-MVC框架的缺点就是return直接返回默认的是forWord 要是redirect的话编码的格式是IOS—i88591的编码
		//所以想返回中文的话就使用ModelAndView
	   ModelAndView modelAndView = new ModelAndView("redirect:/index.do");
	   modelAndView.addObject("success", "恭喜");
	   modelAndView.addObject("url", "goto_spu.do");
	   modelAndView.addObject("title", "spu信息");
		return modelAndView;
}else {
	return "manager_index";
}

}

}
