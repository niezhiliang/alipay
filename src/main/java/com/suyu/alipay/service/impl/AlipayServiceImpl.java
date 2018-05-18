package com.suyu.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.suyu.alipay.config.AlipayConfig;
import com.suyu.alipay.entity.RefundRequestParams;
import com.suyu.alipay.entity.qrcode.*;
import com.suyu.alipay.service.AlipayService;
import com.suyu.alipay.utils.ParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private AlipayConfig alipayConfig;
    private Logger logger = Logger.getLogger("com.suyu.alipay.service.impl.AlipayServiceImpl");

    /**
     * 通用的退款接口
     * @param requestParams
     * @return
     */
    @Override
    public RefundResponse pcRefund(RefundRequestParams requestParams) {
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent(JSON.toJSONString(requestParams));
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            RefundResponseSign refundResponseSign = JSON.parseObject(response.getBody(),RefundResponseSign.class);
        return refundResponseSign.getAlipay_trade_refund_response();
        }
        return null;
    }
    /**
     * 扫码运行代码
     * 验签通过返回QrResponse
     * 失败打印日志信息
     * @param model
     * @return
     */
    @Override
    public QrCodeResponse qrcodePay(AlipayTradePrecreateModel model) {
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(model);
        request.setNotifyUrl(alipayConfig.getNotify_url());
        AlipayTradePrecreateResponse alipayTradePrecreateResponse = null;
        try {
            alipayTradePrecreateResponse = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        QrResponse qrResponse = JSON.parseObject(alipayTradePrecreateResponse.getBody(),QrResponse.class);
        return qrResponse.getAlipay_trade_precreate_response();
    }

    /**
     * 扫码支付的回调
     * @param request
     * @return
     */
    @Override
    public QrServiceEntity alipayNotify(HttpServletRequest request) {
        Map<String, String> map = ParamsUtil.ParamstoMap(request);
        QrServiceEntity qrServiceEntity = new QrServiceEntity();
        qrServiceEntity.setIsreceive(false);
        for (String key :map.keySet()) {
            System.out.println("[ "+key + " = "+map.get(key)+" ]");
        }
        try {
            boolean flag = AlipaySignature.rsaCheckV1(map,alipayConfig.getAlipay_public_key() ,alipayConfig.getCharset(),
                    alipayConfig.getSign_type());
            String json = JSON.toJSONString(map);
            logger.info("Alipay notify===>"+json);
            if (flag) {
                qrServiceEntity.setTran_starus(map.get("trade_status"));
                return qrServiceEntity;
            }
            else {
                return qrServiceEntity;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return qrServiceEntity;
        }
    }

    /**
     * 退款查询接口
     * @param refundQueryParams
     * @return
     */
    @Override
    public RefundQueryResponse refundQuery(RefundQueryParams refundQueryParams) {
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        request.setBizContent(JSON.toJSONString(refundQueryParams));
        AlipayTradeFastpayRefundQueryResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        RefundQueryResponseSign refundQueryResponseSign = JSON.parseObject(response.getBody(),RefundQueryResponseSign.class);
        if(response.isSuccess()){
           return refundQueryResponseSign.getAlipay_trade_fastpay_refund_query_response();
        } else {//订单不存在执行

        }
        return null;
    }

    /**
     * 获取AlipayClient对象
     * @return
     */
    private AlipayClient getAlipayClient() {
        AlipayClient alipayClient =
                new DefaultAlipayClient(alipayConfig.getGatewayUrl(), alipayConfig.getApp_id(), alipayConfig.getMerchant_private_key(),
                        "JSON", alipayConfig.getCharset(), alipayConfig.getAlipay_public_key(), alipayConfig.getSign_type()); //获得初始化的AlipayClient

        return alipayClient;

    }
}
