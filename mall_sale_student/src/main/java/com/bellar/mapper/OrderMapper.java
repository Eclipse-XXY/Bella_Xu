package com.bellar.mapper;

import java.util.List;

import com.bellar.bean.T_MALL_FLOW;
import com.bellar.bean.T_MALL_ORDER;
import com.bellar.bean.T_MALL_ORDER_INFO;

public interface OrderMapper {
	void insert_order(T_MALL_ORDER t_MALL_ORDER);

	void insert_order_infos(List<T_MALL_ORDER_INFO> list);

	void insert_flow(T_MALL_FLOW t_MALL_FLOW);

	void delete_shoppingCars(List<Integer> list);

	void update_order(T_MALL_ORDER t_MALL_ORDER);

	void update_flow(T_MALL_FLOW t_MALL_FLOW);

	void update_kc(T_MALL_ORDER_INFO t_MALL_ORDER_INFO);

	int select_kc(T_MALL_ORDER_INFO t_MALL_ORDER_INFO);

}
