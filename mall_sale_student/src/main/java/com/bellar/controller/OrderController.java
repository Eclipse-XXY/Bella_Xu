package com.bellar.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bellar.bean.OBJECT_T_MALL_FLOW;
import com.bellar.bean.OBJECT_T_MALL_ORDER;
import com.bellar.bean.T_MALL_ADDRESS;
import com.bellar.bean.T_MALL_ORDER_INFO;
import com.bellar.bean.T_MALL_SHOPPINGCAR;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.service.AddressServiceInf;
import com.bellar.service.CartServiceInf;
import com.bellar.service.OrderServiceImp;
import com.bellar.service.OrderServiceInf;
//@SessionAttributes相当于在当前的控制层有效的session对象
@Controller
@SessionAttributes("order")
public class OrderController {
	@Autowired
	OrderServiceInf orderServiceImp;
	@Autowired
	AddressServiceInf addressServiceInf;
	@Autowired
	CartServiceInf cartServiceImp;
	@RequestMapping("sale_pay_success")	
	public String save_pay_success() {
		// 跳转到支付服务成功界面
		return "sale_pay_success";
	}
	@RequestMapping("sale_pay")	
	public String save_pay() {
		// 跳转到支付服务
		return "sale_pay";
	}
	@RequestMapping("order_pay")
	public String order_pay(@ModelAttribute("order") OBJECT_T_MALL_ORDER order) {
	//支付的时候减库存
		orderServiceImp.order_pay(order);
	return "redirect:/sale_pay_success.do";
	}
	@RequestMapping("save_order")	
public String save_order(int address_id,@ModelAttribute("order")OBJECT_T_MALL_ORDER order,HttpSession session,ModelMap map) {
	//@ModelAttribute表示从刚才的那个@SessionAttributes当中取出来
	T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
	T_MALL_ADDRESS address = addressServiceInf.get_address_by_id(address_id);
	//调用提交订单的业务层将订单信息持久化
	orderServiceImp.save_order(order,user,address);
	// 清理session中订单对象
	session.setAttribute("list_cart_session", cartServiceImp.get_list_cart_by_userid(user.getId()));
	return "redirect:/sale_pay.do";
	}
@RequestMapping("/goto_order")
public String goto_order(HttpSession session,ModelMap map) {
List<T_MALL_SHOPPINGCAR>  list_cart=new ArrayList<>();
T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");
List<T_MALL_ADDRESS> list_address = addressServiceInf.get_address_by_userid(user);
list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
//这个是用户的订单用户的一个订单可能对应多个物流
OBJECT_T_MALL_ORDER t_MALL_ORDER = new OBJECT_T_MALL_ORDER();
List<OBJECT_T_MALL_FLOW> list_flow=new ArrayList<>();
BigDecimal zje=new BigDecimal("0");
//后写的步骤//拆单 更具库存地址拆单

//先写的步骤//先获取购物车中有多少个商品的库存地址
	//1将购物车中的库存地址进行去从 先将购物车中的所有的购物车的地址遍历出来再进行set去从
	Set<String > list_kcdz=new HashSet<>();
	for (int i = 0; i < list_cart.size(); i++) {
	list_kcdz.add(list_cart.get(i).getKcdz());
	}
	//循环库存地址按照库存地址生成物流单号
Iterator<String> iterator = list_kcdz.iterator();
while (iterator.hasNext()) {
String kcdz=iterator.next();
	//这个是一个物流
OBJECT_T_MALL_FLOW t_MALL_FLOW = new OBJECT_T_MALL_FLOW();
	//一个包裹里面的所有商品 list_info t_MALL_ORDER_INFO是一个商品的信息
List<T_MALL_ORDER_INFO> list_info=new ArrayList<>();
for (int i = 0; i < list_cart.size(); i++) {
	if (list_cart.get(i).getKcdz().equals(kcdz)&&list_cart.get(i).getShfxz().equals("1")) {
	zje=zje.add(new BigDecimal(list_cart.get(i).getHj()+""));
		T_MALL_ORDER_INFO t_MALL_ORDER_INFO = new T_MALL_ORDER_INFO();
	t_MALL_ORDER_INFO.setGwch_id(list_cart.get(i).getId());
	t_MALL_ORDER_INFO.setShp_tp(list_cart.get(i).getShp_tp());
	t_MALL_ORDER_INFO.setSku_id(list_cart.get(i).getSku_id());
	t_MALL_ORDER_INFO.setSku_jg(list_cart.get(i).getSku_jg());
	t_MALL_ORDER_INFO.setSku_kcdz(list_cart.get(i).getKcdz());
	t_MALL_ORDER_INFO.setSku_mch(list_cart.get(i).getSku_mch());
	t_MALL_ORDER_INFO.setSku_shl(list_cart.get(i).getTjshl());
	list_info.add(t_MALL_ORDER_INFO);
	}
}
	//一个物流发送包裹的信息
t_MALL_FLOW.setList_info(list_info);
t_MALL_FLOW.setPsfsh("德邦物流");
t_MALL_FLOW.setYh_id(user.getId());
t_MALL_FLOW.setMqdd(kcdz+"商品未出库");
list_flow.add(t_MALL_FLOW);
}
t_MALL_ORDER.setJdh(1);
t_MALL_ORDER.setYh_id(user.getId());
t_MALL_ORDER.setZje(zje);
t_MALL_ORDER.setList_flow(list_flow);
map.put("order", t_MALL_ORDER);
map.put("list_address", list_address);
	return "sale_order";
}
}
