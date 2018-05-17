package com.suyu.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.suyu.alipay.config.AlipayConfig;
import com.suyu.alipay.entity.PayRequestParams;
import com.suyu.alipay.entity.RefundRequestParams;
import com.suyu.alipay.entity.qrcode.*;
import com.suyu.alipay.service.AlipayService;
import com.suyu.alipay.utils.Bean2MapUtil;
import com.suyu.alipay.utils.ParamsUtil;
import com.suyu.alipay.utils.RespInfo;
import com.suyu.alipay.utils.ResponseCode;
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
     * pc端的下单
     * @param orderParams
     * @return
     */
    @Override
    public String pcPay(PayRequestParams orderParams) {
        System.out.println(alipayConfig);
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());//在公共参数中设置回跳和通知地址
        String json = JSON.toJSONString(orderParams);
        alipayRequest.setBizContent(json);//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }

    /**
     * 通用的退款接口
     * @param requestParams
     * @return
     */
    @Override
    public RespInfo pcRefund(RefundRequestParams requestParams) {
        RespInfo respInfo = new RespInfo();
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
            respInfo.setCode(ResponseCode.SUCCESS);
            RefundResponseSign refundResponseSign = JSON.parseObject(response.getBody(),RefundResponseSign.class);
            respInfo.setContent(refundResponseSign.getAlipay_trade_refund_response());
            respInfo.setMsg("退款成功");
        } else {
            respInfo.setCode(ResponseCode.FAIL);
            respInfo.setMsg("退款失败，请重新尝试退款");
        }
        return respInfo;
    }
    /**
     * 扫码运行代码
     * 验签通过返回QrResponse
     * 失败打印日志信息
     * @param model
     * @return
     */
    @Override
    public RespInfo qrcodePay(AlipayTradePrecreateModel model) {
        RespInfo respInfo = new RespInfo();
        AlipayClient alipayClient = getAlipayClient();
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizModel(model);
        request.setNotifyUrl(alipayConfig.getNotify_url());
        try {
            AlipayTradePrecreateResponse alipayTradePrecreateResponse = alipayClient.execute(request);
            QrResponse qrResponse = JSON.parseObject(alipayTradePrecreateResponse.getBody(),QrResponse.class);
            Map<String,String> map = Bean2MapUtil.beanToMap(qrResponse.getAlipay_trade_precreate_response());
            map.put("sign",qrResponse.getSign());
            boolean flag = AlipaySignature.rsaCheckV1(map,alipayConfig.getAlipay_public_key() ,alipayConfig.getCharset(),
                    alipayConfig.getSign_type());
            if (!flag) {//这个地方到时候要改 flag为真时 才是验签通过
                respInfo.setCode(ResponseCode.SUCCESS);
                respInfo.setMsg("二维码生成成功");
                respInfo.setContent(qrResponse);
            }
            else {
                respInfo.setCode(ResponseCode.SIGN_CHECK_FAIL);
                respInfo.setMsg("验签失败，请重新发起请求");
                respInfo.setContent(qrResponse);
                logger.warning("Alipay generated two-dimensional code signature is changed illegally");
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
            respInfo.setCode(ResponseCode.FAIL);
        }
        return respInfo;
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
    public RespInfo refundQuery(RefundQueryParams refundQueryParams) {
        RespInfo respInfo = new RespInfo();
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
            respInfo.setCode(ResponseCode.SUCCESS);
            respInfo.setContent(refundQueryResponseSign.getAlipay_trade_fastpay_refund_query_response());
        } else {//订单不存在执行
            respInfo.setCode(ResponseCode.SIGN_CHECK_FAIL);
            System.out.println("签名被改动，请重新发起查询");
            respInfo.setContent(refundQueryResponseSign.getAlipay_trade_fastpay_refund_query_response());
        }
        return respInfo;
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
