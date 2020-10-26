package com.example.demo.sf.dp;

import java.util.Arrays;

/**
 https://leetcode-cn.com/problems/coin-change/
 322. 零钱兑换
 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 你可以认为每种硬币的数量是无限的。

  

 示例 1：

 输入：coins = [1, 2, 5], amount = 11
 输出：3
 解释：11 = 5 + 5 + 1
 示例 2：

 输入：coins = [2], amount = 3
 输出：-1
 示例 3：

 输入：coins = [1], amount = 0
 输出：0
 示例 4：

 输入：coins = [1], amount = 1
 输出：1
 示例 5：

 输入：coins = [1], amount = 2
 输出：2
  

 提示：

 1 <= coins.length <= 12
 1 <= coins[i] <= 231 - 1
 0 <= amount <= 231 - 1

 */
//腾讯二面题
//时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 O(S) 个状态，S 为题目所给的总金额。对于每个状态，每次需要枚举 n 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
//空间复杂度：O(S)。DP 数组需要开长度为总金额 S 的空间。
public class coinChange {
    //这个类似爬楼梯问题：即每次可以上的台阶数，最终要上多少台阶可以到达终点, 转化成这个就是用多少个不同面额的硬币能兑换到总金额
    //只不过爬楼梯的每次上去的台阶数是固定的，这里的不同面额的硬币是随机输入的
    //dp方程:f(n) = min(f(n-k),for k in (1,2,5))+1;

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //定义一个数组dp[n],存储凑成该金额所需的最小金币数
        int[] dp = new int[amount + 1];//动态规划的数组长度和amount一致，那么amount特别大的时候内存会溢出。
        Arrays.fill(dp, max);
        //上0级台阶
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //面值要小于等于要凑的金额才行
                if (coins[j] <= i) {
                    //要凑的金额 - 金币面值 + 当前的这个k占用的一次
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
