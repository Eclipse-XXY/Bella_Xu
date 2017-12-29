package com.bellar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.T_MALL_PRODUCT;

import com.bellar.mapper.SpuMapper;
@Service
public class SpuServiceImpl implements SpuService {
@Autowired
private SpuMapper spuMapper;
	@Override
	public Boolean saveSpu(T_MALL_PRODUCT spu, List<String> fileNamelist) {
		int count=0;
		spu.setShp_tp(fileNamelist.get(0));
		int saveflag=spuMapper.saveSpu(spu);
		if (saveflag>0) {
			System.out.println("-------------"+spu.getId());
			count= spuMapper.saveSpuImg(spu.getId(),fileNamelist);
			return count>0?true:false;
		}else {
			return false;
		}
	}
}
//		
//		int count=0;
//		spu.setShp_tp(fileNamelist.get(0));
//		spuMapper.saveSpu(spu);
//		
//			count= spuMapper.saveSpuImg(spu.getId(),fileNamelist);
//			return count>0?true:false;
//		}
//		
	


