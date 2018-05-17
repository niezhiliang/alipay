package com.suyu.alipay.utils;


public interface ResponseCode {
    /**
     * 成功
     */
   String SUCCESS = "10000";

    /**
     * 失败
     */
   String FAIL = "20000";
    /**
     * 验签失败
     */
   String SIGN_CHECK_FAIL = "10001";

    /**
     * 订单不存在
     */
   String ORDER_UNEXIT = "40004";

}
