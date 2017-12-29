package com.bellar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bellar.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_SKU;
import com.bellar.service.AttrService;
import com.bellar.service.SkuService;

@Controller
public class SkuController {
	@Autowired
	SkuService skuServiceImpl;
	@Autowired
	AttrService attrServiceImpl;
	
//	jquery的请求本身三个参数但是我拿对象接受的
	@ResponseBody
@RequestMapping("/get_spu_by_tm")
public List<T_MALL_PRODUCT> get_spu_by_tm(T_MALL_PRODUCT spu) {
	List<T_MALL_PRODUCT> list_spu=skuServiceImpl.get_spu_by_tm(spu);
	return list_spu;
}
@RequestMapping("/get_sku_attr_list_by_class2")
public String get_sku_attr_by_class2id(int class_2_id,ModelMap map) {
	List<OBJECT_T_MALL_ATTR> list_attr = attrServiceImpl.get_attr_by_class_2_id(class_2_id);
	map.put("list_attr", list_attr);
	return "manager_sku_attr_inner";
}
@RequestMapping("/save_sku")
public ModelAndView save_sku(OBJECT_T_MALL_PRODUCT spu,MODEL_T_MALL_SKU_ATTR_VALUE list_av,T_MALL_SKU sku) {
	//为含有中文不使用modelandview也是可以的；
	skuServiceImpl.save_sku(spu,list_av,sku);
	ModelAndView modelAndView = new ModelAndView("redirect:/index.do");
	modelAndView.addObject("success", "恭喜");
	modelAndView.addObject("url", "goto_sku.do");
	modelAndView.addObject("title", "库存信息");
	return modelAndView;//"redirect:goto_sku.do";
}

}
