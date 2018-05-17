package com.suyu.alipay.entity.qrcode;

public class QrCodeResponse {
    /**
     * 返回的状态码
     */
    private String code;

    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 交易的流水号
     */
    private String out_trade_no;

    /**
     * 生成二维码的内容
     */
    private String qr_code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }

    @Override
    public String toString() {
        return "QrCodeResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", qr_code='" + qr_code + '\'' +
                '}';
    }
}
