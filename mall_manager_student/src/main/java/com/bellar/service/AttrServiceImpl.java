package com.bellar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.MODEL_OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.mapper.AttrMapper;
@Service
public class AttrServiceImpl implements AttrService {
@Autowired
AttrMapper attrMapper;
	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(int class_2_id) {
		
		return attrMapper.get_attr_by_class_2_id(class_2_id);
	}
	@Override
	public void add_attr(MODEL_OBJECT_T_MALL_ATTR listObject, int class_2_id) {
		List<OBJECT_T_MALL_ATTR> list_attr = listObject.getList_attr();
		for (OBJECT_T_MALL_ATTR attr : list_attr) {
			Map<String , Object> paramMap=new HashMap<>();
			paramMap.put("class_2_id", class_2_id);
			paramMap.put("attr", attr);
			attrMapper.add_attr(paramMap);
			Map<String , Object> paramMap2=new HashMap<>();
			paramMap2.put("attr_id", attr.getId());
			paramMap2.put("list_value", attr.getList_value());
			attrMapper.add_value(paramMap2);
			
		}
		
	}

}
