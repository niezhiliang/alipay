package com.suyu.alipay.entity;

/**
 * 下单支付扩展参数
 */
public class ExtendRequestParams {
    /**
     * 系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
     */
    private String sys_service_provider_id;

    /**
     * 花呗分期数（目前仅支持3、6、12）注：使用该参数需要仔细阅读“花呗分期接入文档”
     */
    private String hb_fq_num;

    /**
     * 卖家承担收费比例，商家承担手续费传入100，用户承担手续费传入0，
     * 仅支持传入100、0两种，其他比例暂不支持注：使用该参数需要仔细阅读“花呗分期接入文档”
     */
    private String hb_fq_seller_percent;

    public String getSys_service_provider_id() {
        return sys_service_provider_id;
    }

    public void setSys_service_provider_id(String sys_service_provider_id) {
        this.sys_service_provider_id = sys_service_provider_id;
    }

    public String getHb_fq_num() {
        return hb_fq_num;
    }

    public void setHb_fq_num(String hb_fq_num) {
        this.hb_fq_num = hb_fq_num;
    }

    public String getHb_fq_seller_percent() {
        return hb_fq_seller_percent;
    }

    public void setHb_fq_seller_percent(String hb_fq_seller_percent) {
        this.hb_fq_seller_percent = hb_fq_seller_percent;
    }

    public ExtendRequestParams() {
    }

    public ExtendRequestParams(String sys_service_provider_id, String hb_fq_num, String hb_fq_seller_percent) {
        this.sys_service_provider_id = sys_service_provider_id;
        this.hb_fq_num = hb_fq_num;
        this.hb_fq_seller_percent = hb_fq_seller_percent;
    }
}
