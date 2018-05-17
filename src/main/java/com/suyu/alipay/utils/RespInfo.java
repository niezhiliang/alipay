package com.suyu.alipay.utils;

import com.suyu.alipay.entity.qrcode.ReturnInfo;

public class RespInfo extends ReturnInfo {

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
