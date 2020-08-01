package com.blya.malltest.service;

import com.blya.malltest.comm.api.CommonResult;

public interface UmsMemberService {


    CommonResult getAuthCode(String phone);

    CommonResult verifyAuthCode(String phone, String authCode);
}
