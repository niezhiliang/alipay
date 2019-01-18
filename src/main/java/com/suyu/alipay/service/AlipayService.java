package com.suyu.alipay.service;

import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.suyu.alipay.entity.RefundRequestParams;
import com.suyu.alipay.entity.qrcode.*;

import javax.servlet.http.HttpServletRequest;

public interface AlipayService {

    RefundResponse pcRefund(RefundRequestParams requestParams);

    QrCodeResponse qrcodePay(AlipayTradePrecreateModel model);

    QrServiceEntity alipayNotify(HttpServletRequest request);

    RefundQueryResponse refundQuery(RefundQueryParams refundQueryParams);

    String pcPreOrder(PreOrderParams preOrderParams);

}
