/**
 *
 * @date 2015年6月29日 下午2:27:38
 * @author ty
 */
package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.dao.FsssCitiesMapper;
import com.ctdcn.fsss.admin.entity.FsssCities;
import com.ctdcn.fsss.admin.entity.FsssCitiesExample;
import com.ctdcn.fsss.admin.service.ICitiesService;

/**
 *
 * @date 2015年6月29日 下午2:27:38
 * @author ty 
 */
@Service
public class CitiesService implements ICitiesService {
	@Autowired private FsssCitiesMapper fsssCitiesMapper;
	/**
	 *
	 * @date 2015年6月29日 下午2:27:38
	 * @author ty
	 * @param citiesName
	 * @param citiesCode
	 * @return
	 */
	@Override
	public int add(String citiesName, String citiesCode) {
		// TODO Auto-generated constructor stub
		FsssCities fsssCities = new FsssCities();
		fsssCities.setCitiesName(citiesName);
		fsssCities.setCitiesCode(citiesCode);
		return fsssCitiesMapper.insert(fsssCities);
	}

	/**
	 *
	 * @date 2015年6月29日 下午2:27:38
	 * @author ty
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@Override
	public Pages getAll(int pageNo, int pageSize) {
		// TODO Auto-generated constructor stub
		Pages pages = new Pages();
		List list = new ArrayList();
		
		FsssCitiesExample example = new FsssCitiesExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = fsssCitiesMapper.countByExample(example);
		pages.setTotal(count);
		
		list = fsssCitiesMapper.selectByExample(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年6月29日 下午4:39:02
	 * @author ty
	 * @return
	 */
	@Override
	public JSONArray getAll() {
		// TODO Auto-generated constructor stub
		List<FsssCities> list = fsssCitiesMapper.selectByExample(null);
		JSONArray array = new JSONArray();
		if(CollectionUtils.isNotEmpty(list)){
			for(int i=0 ;i<list.size(); i++){
				FsssCities fc = list.get(i);
				JSONObject j = new JSONObject();
				j.put("code", fc.getCitiesCode());
				j.put("name", fc.getCitiesName());
				array.add(j);
			}
		}
		return array;
	}

}
