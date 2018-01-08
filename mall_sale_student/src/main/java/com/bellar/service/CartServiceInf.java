package com.bellar.service;

import java.math.BigDecimal;
import java.util.List;

import com.bellar.bean.T_MALL_SHOPPINGCAR;

public interface CartServiceInf {

	void add_cart(T_MALL_SHOPPINGCAR cart);

	void update_cart(T_MALL_SHOPPINGCAR t_MALL_SHOPPINGCAR);

	List<T_MALL_SHOPPINGCAR> get_list_cart_by_userid(int id);
 BigDecimal get_total_monery(int sku_id);

T_MALL_SHOPPINGCAR get_cart_item_by_skuid(int sku_id);
}
