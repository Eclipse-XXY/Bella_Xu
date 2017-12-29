package com.bellar.controller;

import java.util.List;

import org.jasypt.util.binary.StrongBinaryEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bellar.bean.DETAIL_T_MALL_SKU;
import com.bellar.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_SKU;
import com.bellar.bean.T_MALL_SKU;
import com.bellar.service.SearchService;

@Controller
public class SearchController {
@Autowired
SearchService searchServiceImp;
@RequestMapping("class_2_sku_search")
public String class_2_sku_search(int class_2_id,String class_2_name,ModelMap map) {
	List<OBJECT_T_MALL_SKU> list_sku= searchServiceImp.get_sku_by_class_2(class_2_id);
	List<OBJECT_T_MALL_ATTR> list_attr= searchServiceImp.get_attr_by_class_2(class_2_id);
	map.put("class_2_name", class_2_name);
	map.put("class_2_id", class_2_id);
	map.put("list_sku", list_sku);
	map.put("list_attr", list_attr);
	return "sale_search";
}
@RequestMapping("get_sku_by_attr")
public String get_sku_by_attr(int class_2_id,String order,ModelMap map,MODEL_T_MALL_SKU_ATTR_VALUE list_av) {
	List<OBJECT_T_MALL_SKU> list_sku= searchServiceImp.get_sku_by_attr(order,class_2_id,list_av.getList_av());
	map.put("list_sku", list_sku);
	return "sale_search_inner";
}
@RequestMapping("get_sku_by_id")
public String get_sku_by_id(int sku_id,int spu_id,ModelMap map) {
	DETAIL_T_MALL_SKU obj_sku=	searchServiceImp.get_sku_detail_by_id(sku_id);
	List<OBJECT_T_MALL_SKU> list_sku= searchServiceImp.get_sku_by_spu(spu_id);
	map.put("list_sku", list_sku);
	map.put("obj_sku", obj_sku);
	return "sale_search_detail";
}

}
