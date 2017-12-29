package com.ctdcn.fsss.admin.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctdcn.fsss.admin.entity.TaUserInfo;
import com.ctdcn.fsss.admin.entity.custom.TaUserInfoCus;
import com.ctdcn.fsss.admin.service.ITaUserInfoService;

@Controller
@RequestMapping("ts_user.do")
public class UserInfoController extends BaseController {

	@Autowired
	private ITaUserInfoService taUserInfoService;

	/**
	 * 
	 * @Title: login
	 * @Description: 用户登录
	 * @return String 返回类型
	 * @throws
	 */

	@RequestMapping(params = "method=login")
	public String login(TaUserInfoCus taUserInfo, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> hashmap = new HashMap<String, Object>();
		if (this.getSessionAttr("user") != null) {
			msg = "ok";
		} else {
			if (taUserInfo.getUsername() != null) {
				TaUserInfoCus user = taUserInfoService.login(taUserInfo);
				if (user != null) {
					this.setSessionAttr("user", user);
					msg = "ok";
				} else {
					msg = "用户名或秘密错误";
				}

			} else {
				msg = "用户名不能为空";
			}

		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", msg);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(msg);
		} catch (Exception ex1) {
			ex1.printStackTrace();
		} finally {
			out.close();
		}
		return null;

	}

	/**
	 * 
	 * @Title: exit
	 * @Description: 退出系统，清除session
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(params = "method=exit")
	public String exit() {
		this.removeSessionAttr("user");
		return "login";
	}

	/**
	 * 
	 * @Title: updateTsUser
	 * @Description: 更新商户下面的分账户，创建日期、药店、角色不会变
	 * @return String 返回类型
	 * @throws
	 */
	@RequestMapping(params = "method=updateTsUser")
	@ResponseBody
	public Map<String, Object> updateTsUser(TaUserInfo taUserInfo, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
		int i = taUserInfoService.updateTsUser(taUserInfo);
		msg = "ok";
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(msg);
		} catch (Exception ex1) {
			ex1.printStackTrace();
		} finally {
			out.close();
		}
		return null;
	}
}
