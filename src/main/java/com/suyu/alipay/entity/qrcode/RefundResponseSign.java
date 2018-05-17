package com.suyu.alipay.entity.qrcode;

/**
 * 退款响应带签名的
 */
public class RefundResponseSign {
    private RefundResponse alipay_trade_refund_response;

    private String sign;

    public RefundResponse getAlipay_trade_refund_response() {
        return alipay_trade_refund_response;
    }

    public void setAlipay_trade_refund_response(RefundResponse alipay_trade_refund_response) {
        this.alipay_trade_refund_response = alipay_trade_refund_response;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
