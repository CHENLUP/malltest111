package com.blya.malltest.controller;

import com.blya.malltest.comm.api.CommonResult;
import com.blya.malltest.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 22:02
 **/
@RestController
@Api(tags = "/UmsMemberController", description = "用户登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证吗")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    public CommonResult getAuthCode(@RequestParam String phone){
        return memberService.getAuthCode(phone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.GET)
    public CommonResult verifyAuthCode(@RequestParam String phone,
                                       @RequestParam String authCode){
        return memberService.verifyAuthCode(phone, authCode);
    }
}
