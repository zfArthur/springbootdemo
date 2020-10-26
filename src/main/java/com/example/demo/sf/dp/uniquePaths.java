package com.example.demo.sf.dp;

import java.util.Arrays;

/*
62. 不同路径
https://leetcode-cn.com/problems/unique-paths/
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

例如，上图是一个7 x 3 的网格。有多少可能的路径？

 

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 
提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9

* */
//解法一: 一维数组法,动态规划，自底向上递推
//时间复杂度: O(m*n)
//空间复杂度: O(n)
class uniquePaths {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //一维的dp数组定义为当前行中，每个元素对应的步数。 二维dp数组dp[i][j] = dp[i-1][j] + dp[i][j-1]很好理解 转化为一维数组， 对于第i行来说，dp[j] = dp[j] + dp[j-1], 等号右边的未赋值之前的dp[j]就是上一行的第j个数据对应的步数，即dp[i-1][j], 等号右边的dp[j-1]是已经更新过的本行的第j-1个数据对应的步数，即dp[i][j-1], 则本行的dp[j] = 上一行的dp[j] + 本行的dp[j-1]， 所以dp[j] = dp[j] + dp[j-1]，即dp[j] += dp[j-1]
                cur[j] = cur[j]+cur[j-1];
            }
        }
        return cur[n-1];
    }
}

//解法二: 二维数组法,动态规划，自底向上递推
//时间复杂度: O(m*n)
//空间复杂度: O(m*n)
//class uniquePaths {
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        //初始化
//        for(int i=0;i<n;i++) dp[0][i] = 1;
//        for(int j=0;j<m;j++) dp[j][0] = 1;
//        //dp方程,注意此处是1,因为上面0已经初始化了
//        for(int j=1;j<m;j++){
//            for(int i=1;i<n;i++){
//                dp[j][i] = dp[j][i-1]+dp[j-1][i];
//            }
//        }
//        return dp[m-1][n-1];
//    }
//}