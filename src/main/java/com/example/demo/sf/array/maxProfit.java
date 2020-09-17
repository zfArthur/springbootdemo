package com.example.demo.sf.array;

/**
 121. 买卖股票的最佳时机
 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

 注意：你不能在买入股票前卖出股票。



 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class maxProfit {

    //暴力解法: 双层for循环
    //时间复杂度: O(n2)
    //写法1：
    public int maxProfit1(int[] prices) {
        //边界条件判断
        if (prices==null||prices.length==0||prices.length==1) return 0;
        int len = prices.length;
        int max = 0;
        for (int i = 0;i< len;i++) {
            for (int j = i+1;j< len;j++) {
                max= Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }
    //暴力解法写法2：
    //不使用数学公式，直接元素交换
    public int maxProfit2(int[] prices) {
        //边界条件判断
        if (prices==null||prices.length==0||prices.length==1) return 0;
        int len = prices.length;
        int max = 0;
        for (int i = 0;i< len;i++) {
            for (int j = i+1;j< len;j++) {
                int temp = prices[j]-prices[i];
                if (temp>max) max =temp;
            }
        }
        return max;
    }
    //一次遍历
    //思路: 计算每次 到当天为止 的最小股票价格和最大利润,最后将最大利润输出
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        //边界条件判断
        if (prices==null||prices.length==0||prices.length==1) return maxProfit;
        int len = prices.length;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0;i< len;i++) {
            if (prices[i]<minPrice) minPrice=prices[i];
            if (prices[i]-minPrice>maxProfit) maxProfit = prices[i]-minPrice;
        }
        return maxProfit;
    }
}
