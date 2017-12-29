package com.bellar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.bellar.bean.OBJECT_T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_PRODUCT;
import com.bellar.bean.T_MALL_SKU;
import com.bellar.mapper.SkuMapper;
@Service
public class skuServiceImpl implements SkuService {
@Autowired
 SkuMapper skuMapper;
	@Override
	public List<T_MALL_PRODUCT> get_spu_by_tm(T_MALL_PRODUCT spu) {
		return skuMapper.get_spu_by_tm(spu);
	}
	@Override
	public void save_sku(OBJECT_T_MALL_PRODUCT spu, MODEL_T_MALL_SKU_ATTR_VALUE list_av, T_MALL_SKU sku) {
		Map<String, Object> paramMap1=new HashMap<>();
		Map<String, Object> paramMap2=new HashMap<>();
		paramMap1.put("spu", spu);
		paramMap1.put("sku", sku);
		skuMapper.save_sku(paramMap1);
		paramMap2.put("spu_id", spu.getSpu_id());
		paramMap2.put("sku_id", sku.getId());
		paramMap2.put("list_av", list_av.getList_av());
		skuMapper.save_sku_av(paramMap2);
	}

}
