package com.suyu.alipay.entity.qrcode;

import com.suyu.alipay.entity.ExtendRequestParams;
import com.suyu.alipay.entity.GoodsDetail;

import java.util.List;

public class QrRequestParams {
    /**
     * 商户订单号,64个字符以内、只能包含字母、数字、
     * 下划线；需保证在商户端不重复
     */
    private String out_trade_no;

    /**
     * 卖家支付宝用户ID。 如果该值为空，
     * 则默认为商户签约账号对应的支付宝用户ID
     */
    private String seller_id;
    /**
     *订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：
     * 【订单总金额】=【打折金额】+【不可打折金额】
     */
    private String total_amount;

    /**
     * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，
     * 取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，
     * 【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
     */
    private String discountable_amount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
     */
    private List<GoodsDetail> goods_detail;

    /**
     * 对交易或商品的描述
     */
    private String body;

    /**
     * 商户操作员编号
     */
    private String operator_id;

    /**
     * 商户门店编号
     */
    private String store_id;

    /**
     *禁用渠道，用户不可用指定渠道支付
     当有多个渠道时用“,”分隔
     注，与enable_pay_channels互斥
     */
    private String disable_pay_channels;

    /**
     * 可用渠道，用户只能在指定渠道范围内支付
     * 当有多个渠道时用“,”分隔
     注，与disable_pay_channels互斥
     */
    private String enable_pay_channels;

    /**
     *商户机具终端编号
     */
    private String terminal_id;

    /**
     * 业务扩展参数
     */
    private ExtendRequestParams extend_params;

    /**
     *该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：
     * 1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，
     * 无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，
     * 可转换为 90m。
     */
    private String timeout_express;

    /**
     *商户传入业务信息，具体值要和支付宝约定，应用于安全，
     * 营销等参数直传场景，格式为json格式
     */
    private String business_params;

    @Override
    public String toString() {
        return "QrRequestParams{" +
                "out_trade_no='" + out_trade_no + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", discountable_amount='" + discountable_amount + '\'' +
                ", subject='" + subject + '\'' +
                ", goods_detail=" + goods_detail +
                ", body='" + body + '\'' +
                ", operator_id='" + operator_id + '\'' +
                ", store_id='" + store_id + '\'' +
                ", disable_pay_channels='" + disable_pay_channels + '\'' +
                ", enable_pay_channels='" + enable_pay_channels + '\'' +
                ", terminal_id='" + terminal_id + '\'' +
                ", extend_params=" + extend_params +
                ", timeout_express='" + timeout_express + '\'' +
                ", business_params='" + business_params + '\'' +
                '}';
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getDiscountable_amount() {
        return discountable_amount;
    }

    public void setDiscountable_amount(String discountable_amount) {
        this.discountable_amount = discountable_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<GoodsDetail> getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(List<GoodsDetail> goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getDisable_pay_channels() {
        return disable_pay_channels;
    }

    public void setDisable_pay_channels(String disable_pay_channels) {
        this.disable_pay_channels = disable_pay_channels;
    }

    public String getEnable_pay_channels() {
        return enable_pay_channels;
    }

    public void setEnable_pay_channels(String enable_pay_channels) {
        this.enable_pay_channels = enable_pay_channels;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public ExtendRequestParams getExtend_params() {
        return extend_params;
    }

    public void setExtend_params(ExtendRequestParams extend_params) {
        this.extend_params = extend_params;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public String getBusiness_params() {
        return business_params;
    }

    public void setBusiness_params(String business_params) {
        this.business_params = business_params;
    }
}
