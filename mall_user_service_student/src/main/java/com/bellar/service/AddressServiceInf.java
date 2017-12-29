package com.bellar.service;

import java.util.List;

import javax.jws.WebService;

import com.bellar.bean.T_MALL_ADDRESS;
import com.bellar.bean.T_MALL_USER_ACCOUNT;
@WebService
public interface AddressServiceInf {
void  add_address(T_MALL_ADDRESS address);
List<T_MALL_ADDRESS> get_address_by_userid(T_MALL_USER_ACCOUNT user );
T_MALL_ADDRESS get_address_by_id(int address_id);
}
