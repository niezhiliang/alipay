package com.suyu.alipay.entity;

/**
 * 支付页面回跳参数
 */
public class CallbackResponseParams {
    /**
     * 支付宝分配给开发者的应用ID
     */
    private String app_id;

    /**
     * 接口名称
     */
    private String method;

    /**
     *签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
     */
    private String sign_type;

    /**
     * 支付宝对本次支付结果的签名，开发者必须使用支付宝公钥验证签名
     */
    private String sign;

    /**
     * 编码格式，如utf-8,gbk,gb2312等
     */
    private String charset;

    /**
     * 前台回跳的时间，格式"yyyy-MM-dd HH:mm:ss"
     */
    private String timestamp;

    /**
     * 调用的接口版本，固定为：1.0
     */
    private String version;

    /**
     *授权方的appid注：由于本接口暂不开放第三方应用授权，
     * 因此auth_app_id=app_id
     */
    private String auth_app_id;

    /**
     * 商户网站唯一订单号
     */
    private String out_trade_no;

    /**
     * 该交易在支付宝系统中的交易流水号。最长64位。
     */
    private String trade_no;

    /**
     *该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
     */
    private String total_amount;

    /**
     * 收款支付宝账号对应的支付宝唯一用户号。 以2088开头的纯16位数字
     */
    private String seller_id;

    public CallbackResponseParams() {
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuth_app_id() {
        return auth_app_id;
    }

    public void setAuth_app_id(String auth_app_id) {
        this.auth_app_id = auth_app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public CallbackResponseParams(String app_id, String method, String sign_type, String sign, String charset, String timestamp, String version, String auth_app_id, String out_trade_no, String trade_no, String total_amount, String seller_id) {
        this.app_id = app_id;
        this.method = method;
        this.sign_type = sign_type;
        this.sign = sign;
        this.charset = charset;
        this.timestamp = timestamp;
        this.version = version;
        this.auth_app_id = auth_app_id;
        this.out_trade_no = out_trade_no;
        this.trade_no = trade_no;
        this.total_amount = total_amount;
        this.seller_id = seller_id;
    }
}
