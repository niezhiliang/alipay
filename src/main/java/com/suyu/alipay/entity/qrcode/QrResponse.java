package com.suyu.alipay.entity.qrcode;

/**
 * 扫码返回的二维码参数和签名
 */
public class QrResponse {

    private QrCodeResponse alipay_trade_precreate_response;

    private String sign;

    public QrCodeResponse getAlipay_trade_precreate_response() {
        return alipay_trade_precreate_response;
    }

    public void setAlipay_trade_precreate_response(QrCodeResponse alipay_trade_precreate_response) {
        this.alipay_trade_precreate_response = alipay_trade_precreate_response;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
