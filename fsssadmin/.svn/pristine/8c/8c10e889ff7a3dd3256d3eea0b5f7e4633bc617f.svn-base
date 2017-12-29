/**
 *
 * @date 2015年6月29日 下午2:36:21
 * @author ty
 */
package com.ctdcn.fsss.admin.controller;

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
import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.service.ICitiesService;
/**
 *
 * @date 2015年6月29日 下午2:36:21
 * @author ty 
 */
@RequestMapping("/cities")
@Controller
public class CitiesController extends BaseController{
	@Autowired private ICitiesService citiesService;
	
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
		Pages pages = citiesService.getAll(page, rows);
		return pages;
	}
	
	
	/**
	 * 保存一个部署城市
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
	public Map save(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Map m = new HashMap();
		String citiesName = request.getParameter("citiesName");
		String citiesCode = request.getParameter("citiesCode");
		int r = citiesService.add(citiesName, citiesCode);
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}

	/**
	 * 不分页，以json形式返回全部
	 *
	 * @description 
	 * @param request
	 * @param response
	 * @return
	 *
	 * @date 2015年6月29日 下午5:01:11
	 * @author ty
	 */
	@RequestMapping("all.do")
	@ResponseBody
	public JSONArray all(HttpServletRequest request, HttpServletResponse response) {
		JSONArray json = citiesService.getAll();
		return json;
	}
}
