package com.suyu.alipay.entity.qrcode;



import com.alipay.api.domain.TradeFundBill;

import java.util.List;

public class RefundResponse {
    private String code;

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String buyer_logon_id;

    private String buyer_user_id;

    private String fund_change;

    private String gmt_refund_pay;

    private String out_trade_no;

    private List<TradeFundBill> refund_detail_item_list;

    private String refund_fee;

    private String send_back_fee;

    private String trade_no;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getBuyer_user_id() {
        return buyer_user_id;
    }

    public void setBuyer_user_id(String buyer_user_id) {
        this.buyer_user_id = buyer_user_id;
    }

    public String getFund_change() {
        return fund_change;
    }

    public void setFund_change(String fund_change) {
        this.fund_change = fund_change;
    }

    public String getGmt_refund_pay() {
        return gmt_refund_pay;
    }

    public void setGmt_refund_pay(String gmt_refund_pay) {
        this.gmt_refund_pay = gmt_refund_pay;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(String send_back_fee) {
        this.send_back_fee = send_back_fee;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public List<TradeFundBill> getRefund_detail_item_list() {
        return refund_detail_item_list;
    }

    public void setRefund_detail_item_list(List<TradeFundBill> refund_detail_item_list) {
        this.refund_detail_item_list = refund_detail_item_list;
    }
}
