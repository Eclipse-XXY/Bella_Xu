package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.FsssAd;
import com.ctdcn.fsss.admin.entity.FsssAdExample;
import java.util.List;

public interface FsssAdMapper {
    int countByExample(FsssAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FsssAd record);

    int insertSelective(FsssAd record);

    List<FsssAd> selectByExample(FsssAdExample example);

    FsssAd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsssAd record);

    int updateByPrimaryKey(FsssAd record);
}