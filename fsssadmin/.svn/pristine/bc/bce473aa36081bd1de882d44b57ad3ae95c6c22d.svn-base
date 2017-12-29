/**
 *
 * @date 2015年6月29日 下午4:04:15
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

import com.ctdcn.fsss.admin.common.Pages;
import com.ctdcn.fsss.admin.entity.FsssHomeMenu;
import com.ctdcn.fsss.admin.service.IHomeMenuService;

/**
 *
 * @date 2015年6月29日 下午4:04:15
 * @author ty 
 */
@RequestMapping("/hm")
@Controller
public class HomeMenuController extends BaseController{

	@Autowired private IHomeMenuService homeMenuService;
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
		Pages pages = homeMenuService.getAll(page, rows);
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
	public Map save(HttpServletRequest request, HttpServletResponse response,FsssHomeMenu fhm) {
		Map m = new HashMap();
		int r = homeMenuService.add(fhm);
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
	public Map update(HttpServletRequest request, HttpServletResponse response, FsssHomeMenu fhm) {
		Map m = new HashMap();
		int r = homeMenuService.updateByID(fhm);
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
	public Map delete(HttpServletRequest request, HttpServletResponse response, FsssHomeMenu fhm) {
		Map m = new HashMap();
		int r = homeMenuService.deleteByID(fhm.getId());
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}
	
}
