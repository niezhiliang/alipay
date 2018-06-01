package com.suyu.alipay.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.suyu.alipay.entity.RefundRequestParams;
import com.suyu.alipay.entity.qrcode.QrServiceEntity;
import com.suyu.alipay.entity.qrcode.RefundQueryParams;
import com.suyu.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/")
public class Index {
    @Autowired
    private AlipayService alipayService;
    //退款
    @RequestMapping(value = "refund")
    public String refund(RefundRequestParams refundRequestParams) {
        System.out.println(refundRequestParams);

        return JSON.toJSONString(alipayService.pcRefund(refundRequestParams));
    }
    //退款查询
    @RequestMapping(value = "refund_query")
    public String refundQuery(RefundQueryParams refundQueryParams) {

        return JSON.toJSONString(alipayService.refundQuery(refundQueryParams));
    }
    //生成二维码
    @RequestMapping(value = "qrcode")
    public String qrcode(AlipayTradePrecreateModel model) {
        return JSON.toJSONString(alipayService.qrcodePay(model));
    }
    //支付回调
    @RequestMapping(value = "notify_url",method = RequestMethod.POST)
    public String notifyurl(HttpServletRequest request) {
        QrServiceEntity qrServiceEntity = alipayService.alipayNotify(request);
        if (qrServiceEntity.isIsreceive()) {
            return "success";
        } else {
            return "failer";
        }
    }
}
