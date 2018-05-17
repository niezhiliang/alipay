package com.suyu.alipay.entity.qrcode;

public class QrServiceEntity {

    private boolean isreceive;

    /**
     * WAIT_BUYER_PAY	交易创建，等待买家付款
        TRADE_CLOSED	未付款交易超时关闭，或支付完成后全额退款
        TRADE_SUCCESS	交易支付成功
        TRADE_FINISHED	交易结束，不可退款
     */
    private String tran_starus;

    public boolean isIsreceive() {
        return isreceive;
    }

    public void setIsreceive(boolean isreceive) {
        this.isreceive = isreceive;
    }

    public String getTran_starus() {
        return tran_starus;
    }

    public void setTran_starus(String tran_starus) {
        this.tran_starus = tran_starus;
    }
}
