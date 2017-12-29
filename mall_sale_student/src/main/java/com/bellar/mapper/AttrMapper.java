package com.bellar.mapper;

import java.util.List;
import java.util.Map;

import com.bellar.bean.OBJECT_T_MALL_ATTR;

public interface AttrMapper {

	List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(int class_2_id);

	void add_attr(Map<String, Object> paramMap);

	void add_value(Map<String, Object> paramMap2);

}
