package com.bellar.service;

import java.util.List;

import com.bellar.bean.MODEL_OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_ATTR;

public interface AttrService {

	List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_id(int class_2_id);

	void add_attr(MODEL_OBJECT_T_MALL_ATTR listObject, int class_2_id);

}
