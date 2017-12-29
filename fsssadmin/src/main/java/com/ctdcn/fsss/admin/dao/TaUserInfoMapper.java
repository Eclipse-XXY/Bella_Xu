package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.TaUserInfo;
import com.ctdcn.fsss.admin.entity.TaUserInfoExample;

import java.util.List;

public interface TaUserInfoMapper {
    int countByExample(TaUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaUserInfo record);

    int insertSelective(TaUserInfo record);

    List<TaUserInfo> selectByExample(TaUserInfoExample example);

    TaUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaUserInfo record);

    int updateByPrimaryKey(TaUserInfo record);
}