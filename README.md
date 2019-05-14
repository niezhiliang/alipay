### 简单粗暴的支付宝微信支付项目(一行代码解决)

https://github.com/easy-pay/easy-pay

> 各个过程的图返回数据请看项目的pic目录图片


> `测试请先修改application.yml里面的参数`

### PC端支付(跳到支付宝官网支付)
    127.0.0.1:10086/pcpay?out_trade_no=12345665478&total_amount=0.01&subject=支付宝支付测试&body=支付测试描述

##### 描述: 生产支付所需的二维码链接地址(通过这个地址用插件生产二维码图片扫描进行支付)

##### Request URL: 127.0.0.1:10086/qrcode

##### Request Method: GET

#### 参数：

| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| out_trade_no  |String|  必须  |   交易流水号（不可重复，重复就会显示二维码失效）
| total_amount  |String|  必须  |   订单金额
| subject  |String|  必须  |   订单标题(支付宝官网支付测试)
| body  |String|  必须  |   订单描述

这里只是填了一些必要的参数，更多请求参数详情访问支付宝的开发文档

https://docs.open.alipay.com/api_1/alipay.trade.pay/

### 二维码生成接口
    127.0.0.1:10086/qrcode?totalAmount=0.01&subject=支付宝扫码支付测试&storeId=123456&timeoutExpress=5m&outTradeNo=110112113114115

##### 描述: 生产支付所需的二维码链接地址(通过这个地址用插件生产二维码图片扫描进行支付)

##### Request URL: 127.0.0.1:10086/qrcode

##### Request Method: GET

#### 参数：

| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| totalAmount  |String|  必须  |   订单所需支付金额(0.01)
| subject  |String|  必须  |   订单标题(支付宝扫码支付测试)
| storeId  |String|  必须  |   商铺编号(123456)
| timeoutExpress  |String|  必须  |   订单自动关闭时间(5m)表示五分钟还未完成交易，自动关闭该订单
| outTradeNo  |String|  必须  |   交易流水号（不可重复，重复就会显示二维码失效）

这里只是填了一些必要的参数，更多请求参数详情访问支付宝的开发文档

https://docs.open.alipay.com/api_1/alipay.trade.pay/


#### 响应:
| 名称   | 类型 | 参数描述
| :----: | :---: | :---:
| code  |String| 响应码（10000为成功）
| msg  |Object| 提示信息
| out_trade_no  |String| 商户订单号
| qr_code  |String| 二维码内容

同样响应参数我也只要了一些我自己需要的，更多响应参数访问支付宝开发文档

https://docs.open.alipay.com/api_1/alipay.trade.pay/

得到二维码地址放到该网址去生产二维码：

https://cli.im/

<img src="https://github.com/niezhiliang/alipay/blob/master/pic/gen_qrcode.png" width = "600" height = "300" alt="失败" align=center />





### 支付回调

##### 描述: 支付回调是支付宝来访问你的地址，这个地址必须外网能够访问到（作用就是告诉你当前订单处于什么状态）这里不多解释，直接贴出我项目中的部分代码
```java
/**
     * 扫码的回调
     * @param request
     * @return
     */
    @RequestMapping(value = "notify_url",method = RequestMethod.POST)
    public String notifyurl(HttpServletRequest request) {
        //这里是将阿里回调带回来的参数封装进map里面 然后可以将一些我们需要的数据保存到数据库
        Map<String,String> map = alipayService.alipayNotify(request);
        if (map.get("trade_status").equals("TRADE_SUCCESS")) {//当状态为TRADE_SUCCESS表示用户支付成功啦
            //响应前端使用的是websocket 可以参考我的另一个项目springbootwebsocket
            /************前端响应支付成功让前端跳转到支付成功页面**************/
            String url = websocketurl+"userid="+map.get("out_trade_no");
            url+="&path=success";
            System.out.println(url);
            HttpClientUtils.get(url);
            /*********************************************************/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Alipay alipay = new Alipay();
            alipay.setOuttradeno(map.get("out_trade_no"));
            alipay.setBuyerid(map.get("buyer_id"));
            alipay.setBuyerlogonid(map.get("buyer_logon_id"));
            alipay.setTotalamount(map.get("total_amount"));
            try {
                alipay.setGmtcreate(sdf.parse(map.get("gmt_create")));
                alipay.setGmtpayment(sdf.parse(map.get("gmt_payment")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            alipay.setPaystatus((byte)1);
            alipay.setSubject(map.get("subject"));
            alipay.setReceiptamount(map.get("total_amount"));
            AlipayExample example = new AlipayExample();
            example.createCriteria().andOuttradenoEqualTo(alipay.getOuttradeno());
            alipayModelService.updateByExampleSelective(alipay,example);
            }
            //如果我们这边接收到了支付成功就该返回一个success的字符串给支付宝那边，避免支付宝一直不停的访问我们回调的url
            return "success";
        } else {
            return "failer";
        }
    }
```




### 通用退款接口

    127.0.0.1:10086/refund?refund_amount=0.01&out_trade_no=110112113114115&refund_reason=正常退款

##### 描述: 退款都可以使用这个接口来进行

##### Request URL: 127.0.0.1:10086/refund

##### Request Method: GET

#### 参数：

| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| refund_amount  |String|  必须  |   需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
| out_trade_no  |String|  必须  |  订单支付时传入的商户订单号,不能和 trade_no同时为空。
| refund_reason  |String|  必须  |   退款的原因说明

这里只是填了一些必要的参数，更多请求参数详情访问支付宝的开发文档

https://docs.open.alipay.com/api_1/alipay.trade.refund/

#### 响应:
| 名称   | 类型 | 参数描述
| :----: | :---: | :---:
| code  |String| 响应码（10000为成功）
| msg  |Object| 返回必要内容
| out_trade_no  |String|  	商户订单号 
| buyer_logon_id  |String| 支付者的支付宝账号(159****0143)
| buyer_user_id  |String| 买家在支付宝的用户id(2088312544416136)
| fund_change  |String| 本次退款是否发生了资金变化(Y/N)
| gmt_refund_pay  |String| 退款支付时间
| refund_fee  |String| 退款总金额
| send_back_fee  |String| 退款总金额
| refund_detail_item_list  |List<TradeFundBill>| 退款使用的资金渠道

同样响应参数我也只要了一些我自己需要的，更多响应参数访问支付宝开发文档
https://docs.open.alipay.com/api_1/alipay.trade.refund/


### 退款查询接口

    127.0.0.1:10086/refund_query?trade_no=2018051821001004130589462290&out_trade_no=110112113114115&out_request_no=110112113114115
##### 描述: 退款都可以使用这个接口来进行

##### Request URL: 127.0.0.1:10086/refund_query

##### Request Method: GET

#### 参数：


| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| trade_no  |String|  必须  |   支付宝交易号，和商户订单号不能同时为空
| out_trade_no  |String|  必须  | 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no
| out_request_no  |String|  必须  |   请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号

不懂的可以`微信`问我

<img width="200" height="200" src="https://img-blog.csdn.net/20180605172659802?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MDgyMzA0/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70"/>

