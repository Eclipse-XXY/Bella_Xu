/**
 *
 * @date 2015年6月30日 上午10:35:29
 * @author ty
 */
package com.ctdcn.fsss.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssBusinessGuide;
import com.ctdcn.fsss.admin.service.IBusinessGuideService;
import com.ctdcn.fsss.utils.HttpClientUtil;

/**
 *
 * @date 2015年6月30日 上午10:35:29
 * @author ty 
 */
@RequestMapping("/bg")
@Controller
public class BusinessGuideController extends BaseController {
	@Autowired private IBusinessGuideService businessGuideService;
	/**
	 * 列表展示
	 *
	 * @description 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 *
	 * @date 2015年6月29日 下午2:41:14
	 * @author ty
	 */
	@RequestMapping("list.do")
	@ResponseBody
	public Pages list(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
		}
		Pages pages = businessGuideService.getAll(page, rows);
		return pages;
	}
	
	/**
	 * 保存
	 *
	 * @description 
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 *
	 * @date 2015年6月29日 下午2:41:04
	 * @author ty
	 */
	@RequestMapping("save.do")
	@ResponseBody
	public Map save(HttpServletRequest request, HttpServletResponse response,FsssBusinessGuide fbg) {
		Map m = new HashMap();
		int r = businessGuideService.add(fbg);
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}
	
	/**
	 * 更新
	 *
	 * @description 
	 * @param request
	 * @param response
	 * @param fa
	 * @return
	 *
	 * @date 2015年6月29日 下午4:07:10
	 * @author ty
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public Map update(HttpServletRequest request, HttpServletResponse response,FsssBusinessGuide fbg) {
		Map m = new HashMap();
		int r = businessGuideService.updateByID(fbg);
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}
	
	/**
	 * 删除
	 *
	 * @description 
	 * @param request
	 * @param response
	 * @param fa
	 * @return
	 *
	 * @date 2015年6月29日 下午4:07:17
	 * @author ty
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public Map delete(HttpServletRequest request, HttpServletResponse response,FsssBusinessGuide fbg) {
		Map m = new HashMap();
		int r = businessGuideService.deleteByID(fbg.getId());
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}
	
	/**
	 *  得到全部记录，并以json返回
	 *
	 * @description 
	 * @param request
	 * @param response
	 * @param fbg
	 * @return
	 *
	 * @date 2015年6月30日 下午5:26:07
	 * @author ty
	 */
	@RequestMapping("loginGetAllToJSON.do")
	@ResponseBody
	public JSONArray getAllToJSON(HttpServletRequest request, HttpServletResponse response) {
		String result = null ;
		try {
			result = HttpClientUtil.readForStrem(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray json = businessGuideService.getAll(result);
		return json;
	}
	
	/**
	 * JSONObject
	 *
	 * @description 
	 * @param request
	 * @param response
	 * @param fbg
	 * @return
	 *
	 * @date 2015年7月1日 上午8:59:46
	 * @author ty
	 */
	@RequestMapping("loginGetOneToJSON.do")
	@ResponseBody
	public JSONArray loginGetOneToJSON(HttpServletRequest request, HttpServletResponse response) {
		String result = null ;
		try {
			result = HttpClientUtil.readForStrem(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray json = businessGuideService.getById(result);
		return json;
	}
}
