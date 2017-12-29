package com.bellar.service;

import javax.jws.WebService;

import com.bellar.bean.T_MALL_USER_ACCOUNT;

@WebService
public interface UserServiceInf {
	public String ping(String hello);
public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user);
public Integer regest(T_MALL_USER_ACCOUNT user);
public String loginTest(T_MALL_USER_ACCOUNT user);
}
