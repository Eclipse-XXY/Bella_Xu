package com.bellar.service;

import java.util.List;

import com.bellar.bean.T_MALL_PRODUCT;

public interface SpuService {

	Boolean saveSpu(T_MALL_PRODUCT spu, List<String> fileNamelist);

}
