package com.bellar.service;

import java.util.List;

import com.bellar.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.bellar.bean.OBJECT_T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_SKU;

public interface SkuService {

	List<T_MALL_PRODUCT> get_spu_by_tm(T_MALL_PRODUCT spu);

	void save_sku(OBJECT_T_MALL_PRODUCT spu, MODEL_T_MALL_SKU_ATTR_VALUE list_av, T_MALL_SKU sku);

}
