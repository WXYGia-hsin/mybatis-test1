package com.wang.dao;

import com.wang.model.Children;
import com.wang.model.ChildrenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChildrenMapper {
    int countByExample(ChildrenExample example);

    int deleteByExample(ChildrenExample example);

    int deleteByPrimaryKey(Integer childid);

    int insert(Children record);

    int insertSelective(Children record);

    List<Children> selectByExample(ChildrenExample example);

    Children selectByPrimaryKey(Integer childid);

    int updateByExampleSelective(@Param("record") Children record, @Param("example") ChildrenExample example);

    int updateByExample(@Param("record") Children record, @Param("example") ChildrenExample example);

    int updateByPrimaryKeySelective(Children record);

    int updateByPrimaryKey(Children record);
}