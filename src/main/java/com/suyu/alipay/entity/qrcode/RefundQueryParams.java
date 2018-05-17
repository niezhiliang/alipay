package com.suyu.alipay.entity.qrcode;

/**
 * 退款状态查询接口
 */
public class RefundQueryParams {
    /**
     * 退款返回的交易流水号
     */
    private String trade_no;

    /**
     * 退款的商户订单号
     */
    private String out_trade_no;

    /**
     *退款请求号
     */
    private String out_request_no;

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

    public String getOut_request_no() {
        return out_request_no;
    }

    public void setOut_request_no(String out_request_no) {
        this.out_request_no = out_request_no;
    }
}
