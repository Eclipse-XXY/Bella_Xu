package com.bellar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ws.security.transform.STRTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.DETAIL_T_MALL_SKU;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_SKU;
import com.bellar.bean.T_MALL_SKU_ATTR_VALUE;
import com.bellar.mapper.AttrMapper;
import com.bellar.mapper.SearchMapper;

@Service
public class SearchServiceImp implements SearchService {
@Autowired
SearchMapper searchMapper;
@Autowired
AttrMapper attrMapper;
	@Override
	public List<OBJECT_T_MALL_SKU> get_sku_by_class_2(int class_2_id) {
		return searchMapper.get_sku_by_class_2(class_2_id);
	}

	@Override
	public List<OBJECT_T_MALL_ATTR> get_attr_by_class_2(int class_2_id) {
		return attrMapper.get_attr_by_class_2_id(class_2_id);
	}

	@Override
	public List<OBJECT_T_MALL_SKU> get_sku_by_attr(String order, int class_2_id, List<T_MALL_SKU_ATTR_VALUE> list_av) {
		StringBuffer sql=new StringBuffer("");
		if (list_av!=null && list_av.size()>0) {
			//分类属性查询动态拼接SQL语句注意前后要加一个空格要不然在拼接的过程当中可能将多个单词连接到了一块
			sql.append(" and sku.id in ");
			sql.append(" (select sku_0.sku_id from ");
			for (int i = 0; i <list_av.size(); i++) {
				sql.append(" (select sku_id from t_mall_sku_attr_value where shxm_id = "+list_av.get(i).getShxm_id()
						+" and shxzh_id = "+list_av.get(i).getShxzh_id()+") sku_"+i+" ");
				if (i<list_av.size()-1) {
					sql.append(" , ");
				}
			}
			if (list_av.size()>1) {
				sql.append(" where ");
			 for (int i=0;i<(list_av.size()-1);i++) {
					sql.append(" sku_" + i + ".sku_id = sku_" + (i + 1) + ".sku_id ");
					if (list_av.size()>2 && i<(list_av.size()-2)) {
						sql.append(" and ");
						
					}
			 	}
			}
			sql.append(" ) ");
		}
		Map<Object, Object> map=new HashMap<>();
		map.put("class_2_id", class_2_id);
		map.put("sql", sql);
		if (StringUtils.isNotBlank(order)) {
			map.put("order", order);
		}
		return searchMapper.select_sku_by_attr(map);
	}

	@Override
	public DETAIL_T_MALL_SKU get_sku_detail_by_id(int sku_id) {
		return searchMapper.get_sku_detail_by_id(sku_id);
	}

	@Override
	public List<OBJECT_T_MALL_SKU> get_sku_by_spu(int spu_id) {
		return searchMapper.get_sku_by_spu(spu_id);
	}

}
