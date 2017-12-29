package com.bellar.mapper;

import java.util.List;
import java.util.Map;

import com.bellar.bean.DETAIL_T_MALL_SKU;
import com.bellar.bean.OBJECT_T_MALL_SKU;

public interface SearchMapper {

	List<OBJECT_T_MALL_SKU> get_sku_by_class_2(int class_2_id);

	List<OBJECT_T_MALL_SKU> select_sku_by_attr(Map<Object, Object> map);

	DETAIL_T_MALL_SKU get_sku_detail_by_id(int sku_id);

	List<OBJECT_T_MALL_SKU> get_sku_by_spu(int spu_id);

}
