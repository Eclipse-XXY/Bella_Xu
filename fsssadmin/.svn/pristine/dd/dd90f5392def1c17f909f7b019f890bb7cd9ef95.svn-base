package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.TStoreInfo;
import com.ctdcn.fsss.admin.entity.TStoreInfoExample;
import com.ctdcn.fsss.admin.entity.TStoreInfoWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TStoreInfoMapper {
    int countByExample(TStoreInfoExample example);

    int deleteByExample(TStoreInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStoreInfoWithBLOBs record);

    int insertSelective(TStoreInfoWithBLOBs record);

    List<TStoreInfoWithBLOBs> selectByExampleWithBLOBs(TStoreInfoExample example);

    List<TStoreInfo> selectByExample(TStoreInfoExample example);

    TStoreInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStoreInfoWithBLOBs record, @Param("example") TStoreInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TStoreInfoWithBLOBs record, @Param("example") TStoreInfoExample example);

    int updateByExample(@Param("record") TStoreInfo record, @Param("example") TStoreInfoExample example);

    int updateByPrimaryKeySelective(TStoreInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TStoreInfoWithBLOBs record);

    int updateByPrimaryKey(TStoreInfo record);
}