package com.blya.malltest.controller;

import com.blya.malltest.comm.api.CommonResult;
import com.blya.malltest.dto.UmsAdminLoginParam;
import com.blya.malltest.mbg.model.UmsAdmin;
import com.blya.malltest.mbg.model.UmsPermission;
import com.blya.malltest.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description  后台管理
 * @Author Chenlup
 * Date 2020/7/9 14:38
 **/

@Api(tags = "admin", description = "后台管理")
@RestController
@RequestMapping(value = "/admin")
public class UmsAdminController {

    @Autowired
    private UmsAdminService adminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminDto, BindingResult result){

        UmsAdmin umsAdmin = adminService.register(umsAdminDto);
        if (umsAdmin == null){
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "用户登录，返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result){

        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());

        if (token == null){
            return CommonResult.validateFailed("用户名密码错误！");
        }
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);

        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取所有用户权限")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}
