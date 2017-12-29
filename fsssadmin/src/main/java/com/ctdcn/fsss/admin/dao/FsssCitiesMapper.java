package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.FsssCities;
import com.ctdcn.fsss.admin.entity.FsssCitiesExample;

import java.util.List;

public interface FsssCitiesMapper {
    int countByExample(FsssCitiesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FsssCities record);

    int insertSelective(FsssCities record);

    List<FsssCities> selectByExample(FsssCitiesExample example);

    FsssCities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsssCities record);

    int updateByPrimaryKey(FsssCities record);
}