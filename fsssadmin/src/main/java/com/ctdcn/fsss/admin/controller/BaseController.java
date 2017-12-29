package com.ctdcn.fsss.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ctdcn.fsss.admin.entity.custom.TaUserInfoCus;

/**
 * 
 * @Description: controller基类
 * @author zhaojimeng
 * @date 2014年6月25日 上午8:36:07
 * 
 */
public class BaseController {
	protected String url;
	protected String msg; // 消息内容
	protected int rows = 10;// 每页条数
	protected int page = 1; // 当前页数
	protected String order; // 排序方式
	protected String sort; // 排序字段

	/**
	 * 获取request对象
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public String getpara(String key) {
		return this.getRequest().getParameter(key);
	}

	/**
	 * 获取session对象
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession(true);
	}

	/**
	 * 向session中放值
	 * 
	 * @param key
	 *            键
	 * @param obj
	 *            内容
	 */
	public void setSessionAttr(String key, Object obj) {
		getSession().setAttribute(key, obj);
	}

	/**
	 * 从session中取值
	 * 
	 * @param key
	 *            键
	 * @return object 内容
	 */
	public Object getSessionAttr(String key) {
		return getSession().getAttribute(key);
	}

	public void removeSessionAttr(String key) {
		getSession().removeAttribute(key);
	}

	/**
	 * 返回用户session
	 * 
	 * @return TaUserInfo
	 */
	public TaUserInfoCus getSessionUser() {
		return (TaUserInfoCus) getSessionAttr("user");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getRows() {
		if (getpara("rows") != null) {
			return Integer.parseInt(getpara("rows"));
		}
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		if (getpara("page") != null) {
			return Integer.parseInt(getpara("page"));
		}
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getOrder() {
		return getpara("order");
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return getpara("sort");
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
