package com.suyu.alipay.entity;

import java.util.Date;

/**
 * 退款响应参数
 */
public class RefundResponseParams {
    /**
     *支付宝交易号
     */
    private String trade_no;

    /**
     *商户订单号
     */
    private String out_trade_no;

    /**
     * 用户的登录id
     */
    private String buyer_logon_id;

    /**
     * 本次退款是否发生了资金变化
     */
    private String fund_change;

    /**
     *退款总金额
     */
    private String refund_fee;

    /**
     * 退款币种信息
     */
    private String refund_currency;

    /**
     * 退款支付时间
     */
    private Date gmt_refund_pay;

    /**
     * 退款使用的资金渠道
     */
    private TradeFundBill refund_detail_item_list;

    /**
     * 交易在支付时候的门店名称
     */
    private String store_name;

    /**
     * 	买家在支付宝的用户id
     */
    private String buyer_user_id;

    /**
     * 本次退款金额中买家退款金额
     */
    private String present_refund_buyer_amount;

    /**
     *本次退款金额中平台优惠退款金额
     */
    private String present_refund_discount_amount;

    /**
     * 本次退款金额中商家优惠退款金额
     */
    private String present_refund_mdiscount_amount;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getFund_change() {
        return fund_change;
    }

    public void setFund_change(String fund_change) {
        this.fund_change = fund_change;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getRefund_currency() {
        return refund_currency;
    }

    public void setRefund_currency(String refund_currency) {
        this.refund_currency = refund_currency;
    }

    public Date getGmt_refund_pay() {
        return gmt_refund_pay;
    }

    public void setGmt_refund_pay(Date gmt_refund_pay) {
        this.gmt_refund_pay = gmt_refund_pay;
    }

    public TradeFundBill getRefund_detail_item_list() {
        return refund_detail_item_list;
    }

    public void setRefund_detail_item_list(TradeFundBill refund_detail_item_list) {
        this.refund_detail_item_list = refund_detail_item_list;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }

    public String getPresent_refund_buyer_amount() {
        return present_refund_buyer_amount;
    }

    public void setPresent_refund_buyer_amount(String present_refund_buyer_amount) {
        this.present_refund_buyer_amount = present_refund_buyer_amount;
    }

    public String getPresent_refund_discount_amount() {
        return present_refund_discount_amount;
    }

    public void setPresent_refund_discount_amount(String present_refund_discount_amount) {
        this.present_refund_discount_amount = present_refund_discount_amount;
    }

    public String getPresent_refund_mdiscount_amount() {
        return present_refund_mdiscount_amount;
    }

    public void setPresent_refund_mdiscount_amount(String present_refund_mdiscount_amount) {
        this.present_refund_mdiscount_amount = present_refund_mdiscount_amount;
    }
}
