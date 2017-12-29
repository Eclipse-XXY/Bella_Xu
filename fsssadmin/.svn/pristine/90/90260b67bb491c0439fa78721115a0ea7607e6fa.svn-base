/**
 *
 * @date 2015年6月30日 上午10:32:48
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
import com.ctdcn.fsss.admin.dao.FsssBusinessGuideMapper;
import com.ctdcn.fsss.admin.entity.FsssBusinessGuide;
import com.ctdcn.fsss.admin.entity.FsssBusinessGuideExample;
import com.ctdcn.fsss.admin.service.IBusinessGuideService;

/**
 * 业务指南
 * @date 2015年6月30日 上午10:32:48
 * @author ty 
 */
@Service
public class BusinessGuideService implements IBusinessGuideService {
	@Autowired private FsssBusinessGuideMapper businessGuideMapper;
	/**
	 *
	 * @date 2015年6月30日 上午10:32:48
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
		
		FsssBusinessGuideExample example = new FsssBusinessGuideExample();
		example.setStart((pageNo - 1) * pageSize);
		example.setLimit(pageSize);
		
		int count = businessGuideMapper.countByExample(example);
		pages.setTotal(count);
		
		list = businessGuideMapper.selectByExampleWithBLOBs(example);
		pages.setRows(list);
		
		return pages;
	}

	/**
	 *
	 * @date 2015年6月30日 上午10:32:48
	 * @author ty
	 * @param fbg
	 * @return
	 */
	@Override
	public int add(FsssBusinessGuide fbg) {
		// TODO Auto-generated constructor stub
		return businessGuideMapper.insert(fbg);
	}

	/**
	 *
	 * @date 2015年6月30日 上午10:32:48
	 * @author ty
	 * @param fbg
	 * @return
	 */
	@Override
	public int updateByID(FsssBusinessGuide fbg) {
		// TODO Auto-generated constructor stub
		return businessGuideMapper.updateByPrimaryKeyWithBLOBs(fbg);
	}

	/**
	 *
	 * @date 2015年6月30日 上午10:32:48
	 * @author ty
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByID(int id) {
		// TODO Auto-generated constructor stub
		return businessGuideMapper.deleteByPrimaryKey(id);
	}

	/**
	 *
	 * @date 2015年6月30日 下午4:57:53
	 * @author ty
	 * @param type
	 * @param citiesCode
	 * @return
	 */
	@Override
	public JSONArray getAll(String jsonString) {
		// TODO Auto-generated constructor stub
		JSONArray array = new JSONArray();
		if(jsonString != null){
			//得到查询条件
			JSONObject json = JSONObject.parseObject(jsonString);
			String citiesCode = json.getString("citiesCode");
			String type = json.getString("type");
			
			//查询条件
			FsssBusinessGuideExample example = new FsssBusinessGuideExample();
			example.createCriteria().andCitiesCodeEqualTo(citiesCode).andTypeEqualTo(type);
			List<FsssBusinessGuide> list = businessGuideMapper.selectByExample(example);
			
			//将list转成json
			if(CollectionUtils.isNotEmpty(list)){
				for(int i = 0; i < list.size(); i++){
					FsssBusinessGuide fbg = list.get(i);
					JSONObject node = new JSONObject();
					node.put("id", fbg.getId());
					node.put("title", fbg.getTitle());
					node.put("path", fbg.getPath());
					array.add(node);
				}
			}
		}
		return array;
	}

	/**
	 *
	 * @date 2015年7月1日 上午8:55:22
	 * @author ty
	 * @param jsonString
	 * @return
	 */
	@Override
	public JSONArray getById(String jsonString) {
		// TODO Auto-generated constructor stub
		JSONArray array = new JSONArray();
		if(jsonString != null){
			//得到查询条件
			JSONObject json = JSONObject.parseObject(jsonString);
			int id = json.getIntValue("id");
			FsssBusinessGuide fbg = businessGuideMapper.selectByPrimaryKey(id);
			
			JSONObject result = new JSONObject();
			result.put("id", fbg.getId());
			result.put("title", fbg.getTitle());
			result.put("content", fbg.getContent());
			array.add(result);
		}
		return array;
	}

}
