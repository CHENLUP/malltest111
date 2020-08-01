package com.blya.malltest.service.impl;

import com.blya.malltest.comm.api.CommonResult;
import com.blya.malltest.service.RedisService;
import com.blya.malltest.service.UmsMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 22:09
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService{

    private static final Logger log = LoggerFactory.getLogger(UmsMemberServiceImpl.class);

    @Value("${redis.key.prefix.authCode}")
    private String PREFIX_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long EXPIRE_CODE;

    @Autowired
    private RedisService redisService;

    @Override
    public CommonResult getAuthCode(String phone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6 ; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        redisService.set(PREFIX_CODE+phone, stringBuilder.toString());
        redisService.expire(PREFIX_CODE+phone, EXPIRE_CODE);
        return CommonResult.success(stringBuilder.toString(),"短信发送成功");
    }

    @Override
    public CommonResult verifyAuthCode(String phone, String authCode) {
        CommonResult commonResult;
        String redultCode = redisService.get(PREFIX_CODE + phone);
        if (redultCode.equals(authCode)){
            commonResult = CommonResult.success(phone);
        }else {
            commonResult = CommonResult.failed(phone  );
        }
        return commonResult;
    }



}
