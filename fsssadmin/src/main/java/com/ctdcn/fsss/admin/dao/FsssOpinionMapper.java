package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.FsssOpinion;
import com.ctdcn.fsss.admin.entity.FsssOpinionExample;

import java.util.List;

public interface FsssOpinionMapper {
    int countByExample(FsssOpinionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FsssOpinion record);

    int insertSelective(FsssOpinion record);

    List<FsssOpinion> selectByExample(FsssOpinionExample example);

    FsssOpinion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FsssOpinion record);

    int updateByPrimaryKey(FsssOpinion record);
}