package com.bellar.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bellar.bean.T_MALL_SHOPPINGCAR;
import com.bellar.mapper.CartMapper;

@Service
public class cartServiceImpl implements CartServiceInf {
@Autowired
CartMapper cartMapper ;
	@Override
	public void add_cart(T_MALL_SHOPPINGCAR cart) {
		cartMapper.add_cart(cart);
	}

	@Override
	public void update_cart(T_MALL_SHOPPINGCAR cart) {
		cartMapper.update_cart(cart);		
	}

	@Override
	public List<T_MALL_SHOPPINGCAR> get_list_cart_by_userid(int id) {
		return cartMapper.get_list_cart_by_userid(id);
	}

	@Override
	public BigDecimal get_total_monery(int sku_id) {
		return cartMapper.get_total_monery( sku_id);
	}

}
