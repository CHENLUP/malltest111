package com.blya.malltest.comm.OrderHandle;

import lombok.Data;

import java.math.BigDecimal;

/**
 * created by chenlup on 2020/7/31 10:19
 **/
@Data
public class Order {

    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
}
