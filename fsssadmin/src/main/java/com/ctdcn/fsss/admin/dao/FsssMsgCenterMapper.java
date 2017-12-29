package com.ctdcn.fsss.admin.dao;

import com.ctdcn.fsss.admin.entity.FsssMsgCenter;
import com.ctdcn.fsss.admin.entity.FsssMsgCenterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FsssMsgCenterMapper {
    long countByExample(FsssMsgCenterExample example);

    int deleteByExample(FsssMsgCenterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FsssMsgCenter record);

    int insertSelective(FsssMsgCenter record);

    List<FsssMsgCenter> selectByExampleWithBLOBs(FsssMsgCenterExample example);

    List<FsssMsgCenter> selectByExample(FsssMsgCenterExample example);

    FsssMsgCenter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FsssMsgCenter record, @Param("example") FsssMsgCenterExample example);

    int updateByExampleWithBLOBs(@Param("record") FsssMsgCenter record, @Param("example") FsssMsgCenterExample example);

    int updateByExample(@Param("record") FsssMsgCenter record, @Param("example") FsssMsgCenterExample example);

    int updateByPrimaryKeySelective(FsssMsgCenter record);

    int updateByPrimaryKeyWithBLOBs(FsssMsgCenter record);

    int updateByPrimaryKey(FsssMsgCenter record);
}