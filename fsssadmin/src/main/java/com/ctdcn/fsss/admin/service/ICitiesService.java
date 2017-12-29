/**
 *
 * @date 2015年6月29日 下午2:24:55
 * @author ty
 */
package com.ctdcn.fsss.admin.service;

import com.alibaba.fastjson.JSONArray;
import com.ctdcn.fsss.admin.common.Pages;

/**
 *
 * @date 2015年6月29日 下午2:24:55
 * @author ty 
 */
public interface ICitiesService {
	public int add(String citiesName,String citiesCode);
	public Pages getAll(int pageNo,int pageSize);
	public JSONArray getAll();
}
