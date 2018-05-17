package com.suyu.alipay.entity;

/**
 * 退款使用的资金渠道
 */
public class TradeFundBill {
    /**
     * 交易使用的资金渠道
     */
    private String fund_channel;

    /**
     *银行卡支付时的银行代码
     */
    private String bank_code;

    /**
     *该支付工具类型所使用的金额
     */
    private String amount;

    /**
     *渠道实际付款金额
     */
    private String real_amount;

    /**
     * 渠道所使用的资金类型,目前只在资金渠道(fund_channel)
     * 是银行卡渠道(BANKCARD)的情况下才返回该信息
     * (DEBIT_CARD:借记卡,CREDIT_CARD:信用卡,MIXED_CARD:借贷合一卡)
     */
    private String fund_type;

    public String getFund_channel() {
        return fund_channel;
    }

    public void setFund_channel(String fund_channel) {
        this.fund_channel = fund_channel;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReal_amount() {
        return real_amount;
    }

    public void setReal_amount(String real_amount) {
        this.real_amount = real_amount;
    }

    public String getFund_type() {
        return fund_type;
    }

    public void setFund_type(String fund_type) {
        this.fund_type = fund_type;
    }
}
