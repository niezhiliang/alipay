package com.suyu.alipay.entity;

/**
 * 商品明细说明(退款用)
 */
public class GoodsDetail {
    /**
     * 商品的编号
     */
    private String goods_id;

    /**
     * 支付宝定义的统一商品编号
     */
    private String alipay_goods_id;

    /**
     *商品名称
     */
    private String goods_name;

    /**
     *商品数量
     */
    private String quantity;

    /**
     *商品单价，单位为元
     */
    private String price;

    /**
     *商品类目
     */
    private String goods_category;

    /**
     * 商品描述信息
     */
    private String body;

    /**
     * 商品的展示地址
     */
    private String show_url;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getAlipay_goods_id() {
        return alipay_goods_id;
    }

    public void setAlipay_goods_id(String alipay_goods_id) {
        this.alipay_goods_id = alipay_goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoods_category() {
        return goods_category;
    }

    public void setGoods_category(String goods_category) {
        this.goods_category = goods_category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShow_url() {
        return show_url;
    }

    public void setShow_url(String show_url) {
        this.show_url = show_url;
    }
}
