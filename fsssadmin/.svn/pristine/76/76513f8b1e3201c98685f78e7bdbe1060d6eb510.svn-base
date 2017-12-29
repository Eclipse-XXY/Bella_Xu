/**
 *
 * @date 2015年6月30日 下午2:32:13
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
import com.ctdcn.fsss.admin.entity.FsssOpinion;
import com.ctdcn.fsss.admin.service.IOpinionService;

/**
 * 反馈
 * @date 2015年6月30日 下午2:32:13
 * @author ty 
 */
@RequestMapping("/opinion")
@Controller
public class OpinionController extends BaseController {
	@Autowired private IOpinionService opinionService;
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
		Pages pages = opinionService.getAll(page, rows);
		return pages;
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
	public Map delete(HttpServletRequest request, HttpServletResponse response,FsssOpinion fo) {
		Map m = new HashMap();
		int r = opinionService.deleteByID(fo.getId());
		if(r > 0){
			m.put("status", "1");
		}else{
			m.put("status", "0");
		}
		return m;
	}
	
}
