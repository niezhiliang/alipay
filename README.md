# alipay
支付宝支付

退款测试
127.0.0.1:10086/refund?refund_amount=0.01&out_trade_no=1526521879590&refund_reason=正常退款
生成二维码
127.0.0.1:10086/qrcode?totalAmount=0.01&subject=支付宝扫码支付测试&storeId=123456&timeoutExpress=5m&outTradeNo=123456789987654321
退款查询
127.0.0.1:10086/refund_query?trade_no=2018051721001004130581677197&out_trade_no=1526521879590&out_request_no=1526521879590