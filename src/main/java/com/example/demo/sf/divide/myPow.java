package com.example.demo.sf.divide;



/*
分治模板
  1. 递归终止条件
  2. 处理本层问题(拆分问题为子问题)
  3. 下跳到下一层
  4. 合并子结果集
  5. 重置本层状态

 */

/*

50. Pow(x, n)
https://leetcode-cn.com/problems/powx-n/

实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

* */

//解法 ： // 2^10 = 2^5*2^5    2^5 = 2^2*2^2 * 2
//分治法 log(n)
class myPow {
    public double myPow(double x, int n) {
        // 注意：这里的类型转换
        // 应对 -2147483648 这种用例
        long  N = n;
        if(N<0){
            x = 1/x;
            N = -N;
        }
        return  subset(x,N);
    }
    public double subset(double x, long n) {
        if (n==0) return 1.0;
        //偶数
        double half = subset(x,n/2);
        if (n%2==0){
            return half*half;
        }else {
            //奇数
            return half*half*x;
        }
    }
}