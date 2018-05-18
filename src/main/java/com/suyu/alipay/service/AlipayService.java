package com.suyu.alipay.service;

import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.suyu.alipay.entity.RefundRequestParams;
import com.suyu.alipay.entity.qrcode.*;
import com.suyu.alipay.utils.RespInfo;

import javax.servlet.http.HttpServletRequest;

public interface AlipayService {

    RespInfo pcRefund(RefundRequestParams requestParams);

    RespInfo qrcodePay(AlipayTradePrecreateModel model);

    QrServiceEntity alipayNotify(HttpServletRequest request);

    RespInfo refundQuery(RefundQueryParams refundQueryParams);

}
