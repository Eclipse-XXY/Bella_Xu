package com.ctdcn.fsss.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctdcn.fsss.admin.dao.TStoreInfoMapper;
import com.ctdcn.fsss.admin.dao.TaUserInfoMapper;
import com.ctdcn.fsss.admin.entity.TStoreInfoExample;
import com.ctdcn.fsss.admin.entity.TStoreInfoWithBLOBs;
import com.ctdcn.fsss.admin.entity.TaUserInfo;
import com.ctdcn.fsss.admin.entity.TaUserInfoExample;
import com.ctdcn.fsss.admin.entity.custom.TaUserInfoCus;
import com.ctdcn.fsss.admin.service.ITaUserInfoService;

@Service
public class TaUserInfoService implements ITaUserInfoService {
	@Autowired
	private TaUserInfoMapper userInfoMapper;

	@Autowired
	private TStoreInfoMapper tStoreInfoMapper;

	// @Override
	// public TaUserInfoCus login(TaUserInfo taUserInfo) {
	// TaUserInfoExample example = new TaUserInfoExample();
	// example.createCriteria().andUsernameEqualTo(taUserInfo.getUsername()).andUserpwdEqualTo(taUserInfo.getUserpwd());
	// List<TaUserInfoCus> list = userInfoMapper.selectByExample(example);
	// if (list.size() > 0) {
	// return list.get(0);
	// } else {
	// return null;
	// }
	//
	// }

	@Override
	public TaUserInfoCus login(TaUserInfo tsUserInfo) {
		TaUserInfoExample example = new TaUserInfoExample();
		// String pwd_md5 = MD5Utils.generatePassword(tsUserInfo.getUserpwd());
		// example.createCriteria().andUsernameEqualTo(tsUserInfo.getUsername()).andUserpwdEqualTo(pwd_md5.toLowerCase());
		example.createCriteria().andUsernameEqualTo(tsUserInfo.getUsername()).andUserpwdEqualTo(tsUserInfo.getUserpwd());
		List<TaUserInfo> list = userInfoMapper.selectByExample(example);
		List<TStoreInfoWithBLOBs> tStoreInfos = new ArrayList<TStoreInfoWithBLOBs>();
		if (list.size() > 0) {
			TaUserInfo tsUserInfo_temp = list.get(0);
			TaUserInfoCus tsUserInfo2 = new TaUserInfoCus();
			tsUserInfo2.setId(tsUserInfo_temp.getId());
			// tsUserInfo2.setFid(tsUserInfo_temp.getFid());
			tsUserInfo2.setRealname(tsUserInfo_temp.getRealname());
			tsUserInfo2.setRoleid(tsUserInfo_temp.getRoleid());
			tsUserInfo2.setUsername(tsUserInfo_temp.getUsername());
			tsUserInfo2.setUserpwd(tsUserInfo_temp.getUserpwd());
			tsUserInfo2.setAccess(tsUserInfo_temp.getAccess());
			tsUserInfo2.setYdid(tsUserInfo_temp.getYdid());
			tsUserInfo2.setMobile(tsUserInfo_temp.getMobile());
			// 判断是否是商户管理员
			// if (tsUserInfo2.getRoleid() == 2) {
			// // 2014-10-28修改：如果是商户管理员不在用ts_user_info的id做主店标识了，用fid做
			// TStoreInfoExample tStoreInfoExample = new TStoreInfoExample();
			// tStoreInfoExample.createCriteria().andFidEqualTo(tsUserInfo2.getFid()).andIsjyEqualTo(0);
			// tStoreInfos =
			// tStoreInfoMapper.selectByExampleWithBLOBs(tStoreInfoExample);
			// } else if (tsUserInfo2.getRoleid() == 3) {
			// 判断是否是操作员
			// String ydidss = tsUserInfo2.getYdid();
			// List listydids = new ArrayList();
			// listydids = StringToList(ydidss);

			TStoreInfoExample tStoreInfoExample2 = new TStoreInfoExample();
			// if ("0".equals(ydidss)) {// 操作员获得全部分店的操作权限
			// tStoreInfoExample2.createCriteria().andFidEqualTo(tsUserInfo2.getFid()).andIsjyEqualTo(0);
			// 替换的
			tStoreInfoExample2.createCriteria().andIsjyEqualTo(0);
			// } else {
			// tStoreInfoExample2.createCriteria().andIdIn(listydids).andIsjyEqualTo(0);
			// }
			tStoreInfos = tStoreInfoMapper.selectByExampleWithBLOBs(tStoreInfoExample2);
			// }
			// 把管理的药店id以逗号隔开存放到Ydids中，方便查询数据库
			tsUserInfo2.setStoreInfoWithBLOBs(tStoreInfos);
			// String ydids = "";
			// for (TStoreInfoWithBLOBs tStoreInfoWithBLOBs : tStoreInfos) {
			// ydids += tStoreInfoWithBLOBs.getId() + ",";
			// }
			// if (!"".equals(ydids)) {
			// ydids = ydids.substring(0, ydids.length() - 1);
			// tsUserInfo2.setYdids(ydids);
			// }
			// System.out.println("))))" + tsUserInfo2.getYdids());
			return tsUserInfo2;
		} else {
			return null;
		}

	}

	@Override
	public int updateTsUser(TaUserInfo taUserInfo) {
		return userInfoMapper.updateByPrimaryKeySelective(taUserInfo);
	}

	public List<Integer> StringToList(String ss) {
		List list = new ArrayList();
		String[] arrayStr = new String[] {};
		arrayStr = ss.split(",");
		list = java.util.Arrays.asList(arrayStr);
		return list;
	}
}
