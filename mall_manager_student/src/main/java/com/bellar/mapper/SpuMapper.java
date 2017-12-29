package com.bellar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bellar.bean.T_MALL_PRODUCT;

public interface SpuMapper {

	int saveSpu(T_MALL_PRODUCT spu);

	int saveSpuImg(@Param("id") int id, @Param("fileNamelist") List<String> fileNamelist);

}
