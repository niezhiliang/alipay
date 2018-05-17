package com.suyu.alipay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 支付宝参数配置
 */
@Component
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    @Value("${alipay.app_id}")
    public  String app_id;

    // 商户私钥，您的PKCS8格式RSA2私钥
    @Value("${alipay.merchant_private_key}")
    public String merchant_private_key;

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    @Value("${alipay.alipay_public_key}")
    public String alipay_public_key;

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @Value("${alipay.notify_url}")
    public  String notify_url;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    @Value("${alipay.return_url}")
    public  String return_url;

    // 签名方式
    @Value("${alipay.sign_type}")
    public  String sign_type;

    // 字符编码格式
    @Value("${alipay.charset}")
    public  String charset;

    // 支付宝网关
    @Value("${alipay.gatewayUrl}")
    public String gatewayUrl;

    // 日志存放
    @Value("${alipay.log_path}")
    public String log_path;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }

    @Override
    public String toString() {
        return "AlipayConfig{" +
                "app_id='" + app_id + '\'' +
                ", merchant_private_key='" + merchant_private_key + '\'' +
                ", alipay_public_key='" + alipay_public_key + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", charset='" + charset + '\'' +
                ", gatewayUrl='" + gatewayUrl + '\'' +
                ", log_path='" + log_path + '\'' +
                '}';
    }
}
