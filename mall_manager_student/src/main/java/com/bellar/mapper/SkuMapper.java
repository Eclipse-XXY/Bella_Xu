package com.bellar.mapper;

import java.util.List;
import java.util.Map;

import com.bellar.bean.T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_SKU;

public interface SkuMapper {

	List<T_MALL_PRODUCT> get_spu_by_tm(T_MALL_PRODUCT spu);

	void save_sku(Map<String, Object> paramMap1);

	void save_sku_av(Map<String, Object> paramMap2);

}
