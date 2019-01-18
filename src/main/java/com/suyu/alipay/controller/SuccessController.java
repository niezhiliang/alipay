package com.suyu.alipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/1/16 下午4:59
 */
@RequestMapping(value = "pay")
@Controller
public class SuccessController {

    /**
     * 支付成功回调页面
     * @return
     */
    @RequestMapping(value = "success")
    public String successPage() {
        return "success";
    }
}
