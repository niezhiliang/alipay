package com.suyu.alipay.utils;

import java.util.Random;

public class RandomUnique {

    /**
     * 随机数 当前时间戳+6位随机数
     * @return
     */
    public static String generateUnique() {
        Random random  = new Random();
        String randomStr =System.currentTimeMillis()+""+(random.nextInt(999999)+100000);

        return randomStr;
    }

    public static void main(String[] args) {
        System.out.println(generateUnique());
    }
}
