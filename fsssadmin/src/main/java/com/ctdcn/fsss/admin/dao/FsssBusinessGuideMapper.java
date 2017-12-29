package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.FsssBusinessGuide;
import com.ctdcn.fsss.admin.entity.FsssBusinessGuideExample;
import java.util.List;

public interface FsssBusinessGuideMapper {
    int countByExample(FsssBusinessGuideExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FsssBusinessGuide record);

    int insertSelective(FsssBusinessGuide record);

    List<FsssBusinessGuide> selectByExampleWithBLOBs(FsssBusinessGuideExample example);

    List<FsssBusinessGuide> selectByExample(FsssBusinessGuideExample example);

    FsssBusinessGuide selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsssBusinessGuide record);

    int updateByPrimaryKeyWithBLOBs(FsssBusinessGuide record);

    int updateByPrimaryKey(FsssBusinessGuide record);
}