package com.bellar.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bellar.bean.T_MALL_SHOPPINGCAR;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.service.CartServiceInf;
import com.bellar.util.MyJsonUtil;

@Controller
public class CartController {
	@Autowired
	CartServiceInf cartServiceImpl;

//	 @RequestMapping("/cart_success")
//	 public String cart_success(ModelMap map,T_MALL_SHOPPINGCAR cart) {
////	 map.put("car_item", cart);
//		 T_MALL_SHOPPINGCAR cart_item =(T_MALL_SHOPPINGCAR)map.get("cart");
//	Map<String, Object> map2 =new HashMap<>();
//	map2.put("cart_item", cart_item);
//	 return "sale_cart_success";
//	 }
	@RequestMapping("change_cart")
	public String change_cart(ModelMap map, String shfxz, int tjshl, int sku_id) {
		// 总共的金额
		BigDecimal sum = new BigDecimal("0");
		BigDecimal single_sku_monery = cartServiceImpl.get_total_monery(sku_id);
		sum.add(single_sku_monery);
		map.put("sum", sum);
		return "sale_cart_list_inner";
	}

	@RequestMapping("get_miniCart")
	public String get_miniCart(ModelMap map, HttpSession session,
			@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie_parm) {
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
		if (user == null) {
			list_cart = MyJsonUtil.json_to_list(list_cart_cookie_parm, T_MALL_SHOPPINGCAR.class);
		} else {
			list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		}
		double sum = 0;
		for (T_MALL_SHOPPINGCAR cart_product : list_cart) {
			double hj = cart_product.getHj();
			sum += hj;
		}
		map.put("sum", sum);
		map.put("list_cart", list_cart);
		return "sale_miniCart_cart_list_inner";
	}

	@RequestMapping("/goto_cart_list")
	public String cart_success(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie_parm,
			HttpSession session, ModelMap map) {
		List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		if (user == null) {
			// 如果用户为空从cookie当中获取
			list_cart = MyJsonUtil.json_to_list(list_cart_cookie_parm, T_MALL_SHOPPINGCAR.class);
		} else {
			// 用户不为空的话从session域当中获取
			list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
		}
		double sum = 0;
		for (T_MALL_SHOPPINGCAR cart_product : list_cart) {
			double hj = cart_product.getHj();
			sum += hj;
		}
		map.put("sum", sum);
		map.put("list_cart", list_cart);
		return "sale_cart_list";
	}

	@RequestMapping("/add_cart")
	public String add_cart(T_MALL_SHOPPINGCAR cart,
			@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie_parm,
			HttpSession session, HttpServletResponse response, ModelMap map) {
		T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
		List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
		if (user == null) {

			// 用户未登录的情况
			if (StringUtils.isBlank(list_cart_cookie_parm)) {
				// 说明cookie没有数据
				list_cart.add(cart);
				map.put("list_cart", list_cart);
			} else {
				// cookie有数据
				list_cart = MyJsonUtil.json_to_list(list_cart_cookie_parm, T_MALL_SHOPPINGCAR.class);
				boolean b = if_new_cart(list_cart, cart);
				if (b) {
					// 表示添加的是新数据
					list_cart.add(cart);
				} else {
					// 老数据
					for (int i = 0; i < list_cart.size(); i++) {
						if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
							// 更新数量和合计
							list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + cart.getTjshl());
							list_cart.get(i).setHj(list_cart.get(i).getHj() + cart.getHj());
							map.put("list_cart", list_cart.get(i));
						}
					}
			
				}
			}

			Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart));
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
		} else {
			// 用户已经登录 的话购物车是送session域当中拿到的地址不是一个集合对象了
			// 从session当中的key获取的对象是一个object对象
			list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
			// 将购物车绑定用户id
			cart.setYh_id(user.getId());
			if (list_cart == null || list_cart.size() == 0) {
				// db和session中没有购物车的数据
				list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
				// 添加db //调用dao层更新和插入的方法
				cartServiceImpl.add_cart(cart);
				list_cart.add(cart);
				map.put("list_cart", list_cart);
				// 向session中插入一条购物车集合的数据
				session.setAttribute("list_cart_session", list_cart);
			} else {
				boolean b = if_new_cart(list_cart, cart);
				if (b) {
					cartServiceImpl.add_cart(cart);// 数据库添加session同时添加数据
					list_cart.add(cart);// 直接更新session中的购物车的数据
					map.put("list_cart", list_cart);
				} else {
					// 更新添加的数量和购物车合计
					for (int i = 0; i < list_cart.size(); i++) {
						if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
							map.put("list_cart", list_cart.get(i));
							list_cart.get(i).setTjshl(cart.getTjshl() + list_cart.get(i).getTjshl());
							list_cart.get(i).setHj(list_cart.get(i).getHj() + cart.getHj());
							cartServiceImpl.update_cart(list_cart.get(i));
						}
						
					}
				}
			}

		}
		return "sale_cart_success";
//	 return "redirect:/cart_success.do";
	}

	private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart_cookie, T_MALL_SHOPPINGCAR cart) {
		// cart是刚传过来的数据如果cart是 集合list_cart购物车当中的数据的时候返回false不是的时候返回true
		boolean b = true;
		for (int i = 0; i < list_cart_cookie.size(); i++) {
			if (list_cart_cookie.get(i).getSku_id() == cart.getSku_id()) {
				b = false;
				break;
			}
		}
		return b;
	}
}
