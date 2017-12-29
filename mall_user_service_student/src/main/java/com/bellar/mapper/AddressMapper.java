package com.bellar.mapper;

import java.util.List;

import com.bellar.bean.T_MALL_ADDRESS;

public interface AddressMapper {

	void insert_address(T_MALL_ADDRESS address);

	List<T_MALL_ADDRESS> get_address_by_userid(int id);

	T_MALL_ADDRESS get_address_by_id(int address_id);

}
