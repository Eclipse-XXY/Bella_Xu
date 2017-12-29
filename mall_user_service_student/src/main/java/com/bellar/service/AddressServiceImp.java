package com.bellar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bellar.bean.T_MALL_ADDRESS;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
import com.bellar.mapper.AddressMapper;

public class AddressServiceImp implements AddressServiceInf {
@Autowired
AddressMapper addressMapper;
	@Override
	public void add_address(T_MALL_ADDRESS address) {
		addressMapper.insert_address(address);
	}

	@Override
	public List<T_MALL_ADDRESS> get_address_by_userid(T_MALL_USER_ACCOUNT user) {
		return addressMapper.get_address_by_userid(user.getId());
	}

	@Override
	public T_MALL_ADDRESS get_address_by_id(int address_id) {
		return addressMapper.get_address_by_id(address_id);
	}

}
