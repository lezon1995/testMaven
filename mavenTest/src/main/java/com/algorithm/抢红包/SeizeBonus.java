package com.algorithm.抢红包;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhuliang
 * @date 2019/6/10 14:12
 */
public class SeizeBonus {
    //发红包算法，金额参数以分为单位
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random(1);
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机范围：[1，剩余人均金额的两倍)，左闭右开
            int amount = random.nextInt(restAmount / restPeopleNum * 2 + 1);
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }


    public static void main(String[] args) {
        int sum = 0;
        List<Integer> amountList = divideRedPackage(100000, 10);
        for (Integer amount : amountList) {
            sum += amount;
            System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
        System.out.println("总计：" + new BigDecimal(sum).divide(new BigDecimal(100)));
    }
}
