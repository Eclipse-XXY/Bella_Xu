package com.bellar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.OBJECT_T_MALL_ORDER;
import com.bellar.bean.T_MALL_ADDRESS;
import com.bellar.bean.T_MALL_ORDER_INFO;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.mapper.OrderMapper;
import com.bellar.util.MyDateUtile;

@Service
public class OrderServiceImp implements OrderServiceInf {
@Autowired
OrderMapper orderMapper;
	public void save_order(OBJECT_T_MALL_ORDER order, T_MALL_USER_ACCOUNT user, T_MALL_ADDRESS address) {
		//用一个list集合将cartid保存下来目的是让订单保存到数据库的时候便于将购物车当中的数据清空
		List<Integer> list_cart_id=new ArrayList<>();
		//保存订单，生成订单号和订单id
		order.setDzh_id(address.getId());
		order.setShhr(address.getShjr());
		order.setDzh_mch(address.getDz_mch());
		orderMapper.insert_order(order);
		//根据订单号，生成物流包裹信息，生成物流id 不生成物流单号
		for (int i = 0; i <order.getList_flow().size(); i++) {
			order.getList_flow().get(i).setPsfsh("德邦物流");
			order.getList_flow().get(i).setYh_id(user.getId());
			//订单id
			order.getList_flow().get(i).setDd_id(order.getId());
			order.getList_flow().get(i).setMqdd("尚未出库");
			order.getList_flow().get(i).setMdd(address.getDz_mch());
		orderMapper.insert_flow(order.getList_flow().get(i));
			//根据物流id批量插入订单信息表
			for (int j = 0; j < order.getList_flow().get(i).getList_info().size(); j++) {
				order.getList_flow().get(i).getList_info().get(j).setFlow_id(order.getList_flow().get(i).getId());
				order.getList_flow().get(i).getList_info().get(j).setDd_id(order.getId());
			
				list_cart_id.add(order.getList_flow().get(i).getList_info().get(j).getGwch_id());
				}
		orderMapper.insert_order_infos(order.getList_flow().get(i).getList_info());
		}
		//删除已经提交的购物车信息
		orderMapper.delete_shoppingCars(list_cart_id);
	}

	@Override
	public void order_pay(OBJECT_T_MALL_ORDER order) {
//修改订单状态
	order.setYjsdshj(MyDateUtile.getMyFlowDate(3));	
	order.setJdh(2);
	orderMapper.update_order(order);
	//修改物流信息
	for (int i = 0; i < order.getList_flow().size(); i++) {
		order.getList_flow().get(i).setPsmsh("德邦物流");
		order.getList_flow().get(i).setPsshj(MyDateUtile.getMyFlowDate(1));
		order.getList_flow().get(i).setYwy("李园园");
		order.getList_flow().get(i).setLxfsh("123456789");
	orderMapper.update_flow(order.getList_flow().get(i));
	for (int j = 0; j < order.getList_flow().get(i).getList_info().size(); j++) {
		//确认库存数量
		boolean b=if_can_by(order.getList_flow().get(i).getList_info().get(j));
	if(b) {
		//修改库存和销量的信息

		orderMapper.update_kc(order.getList_flow().get(i).getList_info().get(j));
	}
	}
	}


	}

	private boolean if_can_by(T_MALL_ORDER_INFO t_MALL_ORDER_INFO) {
		boolean b = false;

		int select_kc = orderMapper.select_kc(t_MALL_ORDER_INFO);

		if (select_kc >= 0) {
			b = true;
		}
		return b;
	}

}
