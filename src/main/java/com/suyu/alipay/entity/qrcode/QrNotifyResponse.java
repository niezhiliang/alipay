package com.suyu.alipay.entity.qrcode;

import java.util.Date;

/**
 * 扫码支付的notify_url的响应参数
 */
public class QrNotifyResponse {

    /**
     * 订单创建时间
     */
    private Date gmt_create;

    /**
     * 编码格式
     */
    private String charset;

    /**
     * 支付宝商户预留邮箱
     */
    private String seller_email;

    /**
     * 回调的时间戳
     */
    private Date notify_time;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 签名
     */
    private String sign;

    /**
     * 用户购买商品时所生成的编号
     */
    private String buyer_id;

    /**
     * 版本
     */
    private String version;

    /**
     * 响应编号
     */
    private String notify_id;

    /**
     * 响应类型
     */
    private String notify_type;

    /**
     * 订单流水号
     */
    private String out_trade_no;

    /**
     * 交易总金额
     */
    private String total_amount;

    /**
     * 当面付状态
     */
    private String trade_status;

    /**
     * 交易编号
     */
    private String trade_no;

    /**
     * 授权appid
     */
    private String auth_app_id;

    /**
     * 支付者账号
     */
    private String buyer_logon_id;

    /**
     * 应用的appid
     */
    private String app_id;

    /**
     * 签名类型
     */
    private String sign_type;

    /**
     * 商户id
     */
    private String seller_id;

    /**
     * 验签结果
     */
    private String precreate_notify_url;

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public Date getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(Date notify_time) {
        this.notify_time = notify_time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getAuth_app_id() {
        return auth_app_id;
    }

    public void setAuth_app_id(String auth_app_id) {
        this.auth_app_id = auth_app_id;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getPrecreate_notify_url() {
        return precreate_notify_url;
    }

    public void setPrecreate_notify_url(String precreate_notify_url) {
        this.precreate_notify_url = precreate_notify_url;
    }

    @Override
    public String toString() {
        return "QrNotifyResponse{" +
                "gmt_create=" + gmt_create +
                ", charset='" + charset + '\'' +
                ", seller_email='" + seller_email + '\'' +
                ", notify_time=" + notify_time +
                ", subject='" + subject + '\'' +
                ", sign='" + sign + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", version='" + version + '\'' +
                ", notify_id='" + notify_id + '\'' +
                ", notify_type='" + notify_type + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", auth_app_id='" + auth_app_id + '\'' +
                ", buyer_logon_id='" + buyer_logon_id + '\'' +
                ", app_id='" + app_id + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", precreate_notify_url='" + precreate_notify_url + '\'' +
                '}';
    }
}
