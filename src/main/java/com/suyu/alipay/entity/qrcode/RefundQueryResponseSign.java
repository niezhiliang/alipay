package com.suyu.alipay.entity.qrcode;

/**
 * 退款查询响应参数带签名
 */
public class RefundQueryResponseSign {
    private RefundQueryResponse alipay_trade_fastpay_refund_query_response;

    private String sign;

    public RefundQueryResponse getAlipay_trade_fastpay_refund_query_response() {
        return alipay_trade_fastpay_refund_query_response;
    }

    public void setAlipay_trade_fastpay_refund_query_response(RefundQueryResponse alipay_trade_fastpay_refund_query_response) {
        this.alipay_trade_fastpay_refund_query_response = alipay_trade_fastpay_refund_query_response;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
