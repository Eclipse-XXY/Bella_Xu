package com.ctdcn.fsss.admin.service;

import com.ctdcn.fsss.admin.entity.TaUserInfo;
import com.ctdcn.fsss.admin.entity.custom.TaUserInfoCus;

public interface ITaUserInfoService {

	public TaUserInfoCus login(TaUserInfo taUserInfo);

	/**
	 * 
	 * @Title: updateTsUser
	 * @Description: 更新商户
	 * @param @param tsUserInfo
	 * @return int 返回类型
	 * @throws
	 */
	public int updateTsUser(TaUserInfo taUserInfo);
}
