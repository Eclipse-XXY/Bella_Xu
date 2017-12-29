package com.bellar.mapper;



import com.bellar.bean.T_MALL_USER_ACCOUNT;


public interface UserMapper {

	T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user);

	int regest(T_MALL_USER_ACCOUNT user);


}
