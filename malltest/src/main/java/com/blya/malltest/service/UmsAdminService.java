package com.blya.malltest.service;

import com.blya.malltest.mbg.model.UmsAdmin;
import com.blya.malltest.mbg.model.UmsPermission;

import java.util.List;

/**
 * @DESC 用户处理
 */
public interface UmsAdminService {

    UmsAdmin getAdminByUsername(String username);

    UmsAdmin register(UmsAdmin umsAdminDto);

    String login(String username, String password);

    List<UmsPermission> getPermissionList(Long adminId);
}
