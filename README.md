# alipay
支付宝支付

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
| outTradeNo  |String|  必须  |   交易流水号（不可重复）

这里只是填了一些必要的参数，更多请求参数详情访问支付宝的开发文档

https://docs.open.alipay.com/api_1/alipay.trade.pay/


#### 响应:
| 名称   | 类型 | 参数描述
| :----: | :---: | :---:
| code  |String| 响应码（10000为成功）
| msg  |Object| 返回必要内容
| out_trade_no  |String| 响应消息
| qr_code  |String| 二维码内容

同样响应参数我也只要了一些我自己需要的，更多响应参数访问支付宝开发文档

https://docs.open.alipay.com/api_1/alipay.trade.pay/

得到二维码地址放到该网址去生产二维码：

https://cli.im/

<img src="https://github.com/niezhiliang/alipay/blob/master/pic/gen_qrcode.png" width = "900" height = "130" alt="失败" align=center />





### 支付回调

##### 描述: 支付回调是支付宝来访问你的地址，这个地址必须外网能够访问到（作用就是告诉你当前订单处于什么状态）




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
| refund_fee  |String| 退款总金额
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

