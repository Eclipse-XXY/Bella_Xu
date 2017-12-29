package com.bellar.service;

import java.util.List;

import com.bellar.bean.DETAIL_T_MALL_SKU;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_SKU;
import com.bellar.bean.T_MALL_SKU_ATTR_VALUE;

public interface SearchService {

	List<OBJECT_T_MALL_SKU> get_sku_by_class_2(int class_2_id);

	List<OBJECT_T_MALL_ATTR> get_attr_by_class_2(int class_2_id);

	List<OBJECT_T_MALL_SKU> get_sku_by_attr(String order, int class_2_id, List<T_MALL_SKU_ATTR_VALUE> list_av);

	DETAIL_T_MALL_SKU get_sku_detail_by_id(int sku_id);

	List<OBJECT_T_MALL_SKU> get_sku_by_spu(int spu_id);

}
