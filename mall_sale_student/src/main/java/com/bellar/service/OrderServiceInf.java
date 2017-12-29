package com.bellar.service;

import com.bellar.bean.OBJECT_T_MALL_ORDER;
import com.bellar.bean.T_MALL_ADDRESS;
import com.bellar.bean.T_MALL_USER_ACCOUNT;

public interface OrderServiceInf {
	public void save_order(OBJECT_T_MALL_ORDER order, T_MALL_USER_ACCOUNT user, T_MALL_ADDRESS address);

	public void order_pay(OBJECT_T_MALL_ORDER order);
}
