/**
 *
 * @date 2015年6月30日 上午10:31:16
 * @author ty
 */
package com.ctdcn.fsss.admin.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssBusinessGuide;

/**
 *
 * @date 2015年6月30日 上午10:31:16
 * @author ty 
 */
public interface IBusinessGuideService {
	public Pages getAll(int pageNo,int pageSize);
	public int add(FsssBusinessGuide fbg);
	public int updateByID(FsssBusinessGuide fbg);
	public int deleteByID(int id);
	/**
	 * 得到全部记录，并以json返回
	 *
	 * @description 
	 * @param jsonString {"citiesCode":"部署地市","type":"业务类型"}
	 * @return
	 *
	 * @date 2015年6月30日 下午5:26:32
	 * @author ty
	 */
	public JSONArray getAll(String jsonString);
	/**
	 * 根据id得到一条记录，并以json返回
	 *
	 * @description 
	 * @param jsonString {"id":"1"}
	 * @return
	 *
	 * @date 2015年7月1日 上午8:54:48
	 * @author ty
	 */
	public JSONArray getById(String jsonString);
}
