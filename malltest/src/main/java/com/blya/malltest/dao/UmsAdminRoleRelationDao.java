package com.blya.malltest.dao;

import com.blya.malltest.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminRoleRelationDao {

    List<UmsPermission> getPermissionList(Long adminId);
}
