package com.blya.malltest.mbg.mapper;

import com.blya.malltest.mbg.model.UmsPermission;
import com.blya.malltest.mbg.model.UmsPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsPermissionMapper {
    int countByExample(UmsPermissionExample example);

    int deleteByExample(UmsPermissionExample example);

    int insert(UmsPermission record);

    int insertSelective(UmsPermission record);

    List<UmsPermission> selectByExample(UmsPermissionExample example);

    int updateByExampleSelective(@Param("record") UmsPermission record, @Param("example") UmsPermissionExample example);

    int updateByExample(@Param("record") UmsPermission record, @Param("example") UmsPermissionExample example);
}