package com.blya.malltest.service;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 15:43
 **/
public interface RedisService {

    /**
     * 设置数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超时时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
