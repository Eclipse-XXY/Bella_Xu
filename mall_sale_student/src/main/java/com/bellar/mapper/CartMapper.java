package com.bellar.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.bellar.bean.T_MALL_SHOPPINGCAR;

public interface CartMapper {

	void add_cart(T_MALL_SHOPPINGCAR cart);

	void update_cart(T_MALL_SHOPPINGCAR cart);

	List<T_MALL_SHOPPINGCAR> get_list_cart_by_userid(int id);

	BigDecimal get_total_monery(int sku_id);

}
