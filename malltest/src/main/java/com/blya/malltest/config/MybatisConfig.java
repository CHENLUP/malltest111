package com.blya.malltest.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 13:22
 **/
@Configuration
@MapperScan({"com.blya.malltest.mbg.mapper","com.blya.malltest.mapper", "com.blya.malltest.dao"})
public class MybatisConfig {
}
