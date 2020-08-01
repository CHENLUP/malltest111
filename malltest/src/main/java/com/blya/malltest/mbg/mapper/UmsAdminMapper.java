package com.blya.malltest.mbg.mapper;

import com.blya.malltest.mbg.model.UmsAdmin;
import com.blya.malltest.mbg.model.UmsAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminMapper {
    int countByExample(UmsAdminExample example);

    int deleteByExample(UmsAdminExample example);

    int insert(UmsAdmin record);

    int insertSelective(UmsAdmin record);

    List<UmsAdmin> selectByExample(UmsAdminExample example);

    int updateByExampleSelective(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);

    int updateByExample(@Param("record") UmsAdmin record, @Param("example") UmsAdminExample example);
}