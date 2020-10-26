package com.example.demo.sf.dichotomy;

/*
69. x 的平方根
https://leetcode-cn.com/problems/sqrtx/

实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
* */

/*
复杂度分析

时间复杂度：O(logx)，即为二分查找需要的次数。

空间复杂度：O(1)
* */
class mySqrt {
    public int mySqrt(int x) {
        //临界条件判断
        if(x==0||x==1) return x;
        long left =1;
        long right =x;
        while (left<=right){
            //为了防止 left + right越界，此处有个技术处理
            long mid = left + (right-left)/2;
            if (mid*mid>x){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return (int)right;
    }
}