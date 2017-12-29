package com.bellar.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bellar.bean.T_MALL_SHOPPINGCAR;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.mapper.UserMapper;
import com.bellar.service.CartServiceInf;
import com.bellar.service.UserServiceInf;
import com.bellar.service.cartServiceImpl;
import com.bellar.util.MyJsonUtil;

@Controller
public class LoginController {
	@Autowired
     UserMapper userMapper;
	@Autowired
	CartServiceInf cartServiceImpl;
	@Autowired
	UserServiceInf userServiceInf;
@RequestMapping("/login")
public String toLogin(String user_type,@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie_parm, HttpServletResponse response,
		HttpSession session, T_MALL_USER_ACCOUNT user) {
	T_MALL_USER_ACCOUNT user_login=null;
	if (user_type.equals("user")) {
		user_login = userServiceInf.login(user);
	} else {
		user_login= userServiceInf.loginTest(user);
	}
	if (user_login==null) {
	return "sale_login";
	}else {
		//第一步先使用session将登陆的用户 的信息保存到session域当中
		session.setAttribute("user", user_login);
		merg_cart(response, session, list_cart_cookie_parm);

		// 向浏览器客户端写入一个保存用户名的cookie
		Cookie cookie=new Cookie("yh_mch", user.getYh_mch());
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		
		//上面再浏览器当中存放的cookie信息是无法存放用户名信息是汉字的信息汉字的信息需要一种新的编码的格式
		String encode="";
	try {
		encode=URLEncoder.encode("徐雪娅", "utf-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	Cookie cookie2 = new Cookie("test", encode);
	cookie2.setMaxAge(60*60);
	response.addCookie(cookie2);
	   return "redirect:/index.do";
	}
}
private void merg_cart(HttpServletResponse response,HttpSession session,
		@CookieValue(value = "list_cart_cookie", required = false)String list_cart_cookie_parm) {
	T_MALL_USER_ACCOUNT user=(T_MALL_USER_ACCOUNT)session.getAttribute("user");
List<T_MALL_SHOPPINGCAR> list_cart_db=cartServiceImpl.get_list_cart_by_userid(user.getId());
if(list_cart_db==null) {
			//数据库当中没有的话看cookie当中有没有
			if(StringUtils.isBlank(list_cart_cookie_parm)) {
				//ok
			}else {
					//添加db
						List<T_MALL_SHOPPINGCAR> list_cart_cookie=MyJsonUtil.json_to_list(list_cart_cookie_parm,T_MALL_SHOPPINGCAR.class);
					for (int i = 0; i < list_cart_cookie.size(); i++) {
						list_cart_cookie.get(i).setYh_id(user.getId());
					cartServiceImpl.add_cart(list_cart_cookie.get(i));
					}
				}
	}
else {
	if (StringUtils.isBlank(list_cart_cookie_parm)) {
		
	}else {
		List<T_MALL_SHOPPINGCAR> list_cart_cookie=MyJsonUtil.json_to_list(list_cart_cookie_parm, T_MALL_SHOPPINGCAR.class);
	for (int i = 0; i < list_cart_cookie.size(); i++) {
		boolean b=if_new_cart(list_cart_db,list_cart_cookie.get(i));
		if (b) {
			list_cart_cookie.get(i).setYh_id(user.getId());
		cartServiceImpl.add_cart(list_cart_cookie.get(i));
		}else {
			for (int j = 0; j <list_cart_db.size(); j++) {
			if (list_cart_db.get(j).getSku_id()==list_cart_cookie.get(i).getSku_id()) {
			list_cart_db.get(j)	.setTjshl(list_cart_cookie.get(i).getTjshl()+list_cart_db.get(j).getTjshl());
			list_cart_db.get(j).setHj(list_cart_cookie.get(i).getHj() + list_cart_db.get(j).getHj());
	cartServiceImpl.update_cart(list_cart_db.get(j));
			}	
			}
		}
	}
	}
}

session.setAttribute("list_cart_session", cartServiceImpl.get_list_cart_by_userid(user.getId()));
Cookie cookie3 = new Cookie("list_cart_cookie", "");
cookie3.setMaxAge(60 * 60);
response.addCookie(cookie3);
}
@RequestMapping("/goto_login")
public String goto_login() {
	return "sale_login";
}
@RequestMapping("goto_logout")
public String goto_logout(HttpSession session) {
	session.invalidate();
	return "redirect:/index.do";
}

private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart_cookie, T_MALL_SHOPPINGCAR cart) {
	boolean b = true;
	for (int i = 0; i < list_cart_cookie.size(); i++) {
		if (list_cart_cookie.get(i).getSku_id() == cart.getSku_id()) {
			b = false;
			break;
		}
	}
	return b;
}
@RequestMapping("/regest")
public String gotoRegest() {
	return "regest";
}
@RequestMapping("/saveuser")
public String doRegest(T_MALL_USER_ACCOUNT user) {
	
	Integer userid = userServiceInf.regest(user);
	if (userid>0) {
		return "redirect:goto_login.do";	
	}
	return "redirect:regest.do";
}
}
