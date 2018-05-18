# alipay
支付宝支付

### 二维码生成接口

##### 描述: 生产支付所需的二维码链接地址(通过这个地址用插件生产二维码图片扫描进行支付)

##### Request URL: 127.0.0.1:10086/qrcode

##### Request Method: GET

#### 参数：

| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| totalAmount  |String|  必须  |   订单所需支付金额
| subject  |String|  必须  |   订单标题
| storeId  |String|  必须  |   商铺编号
| timeoutExpress  |String|  必须  |   订单自动关闭时间
| outTradeNo  |String|  必须  |   交易流水号（不可重复）


#### 响应:
| 名称   | 类型 | 参数描述
| :----: | :---: | :---:
| code  |String| 响应码（10000为成功）
| msg  |Object| 返回必要内容
| out_trade_no  |String| 响应消息
| qr_code  |String| 二维码内容




退款测试
127.0.0.1:10086/refund?refund_amount=0.01&out_trade_no=1526521879590&refund_reason=正常退款
生成二维码
退款查询
127.0.0.1:10086/refund_query?trade_no=2018051721001004130581677197&out_trade_no=1526521879590&out_request_no=1526521879590