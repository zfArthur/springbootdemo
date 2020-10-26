package com.example.demo.sf.dp;

/*
53. 最大子序和
https://leetcode-cn.com/problems/maximum-subarray/
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

*
* */
//时间复杂度O(n)
//空间复杂度O(1)
class maxSubArray {
    public int maxSubArray(int[] nums) {
        //dp:
        //分治(子问题)
        //状态数组定义
        //dp方程: dp[i] = max(nums[i]+0,nums[i]+dp[i-1]);
        //最大子序和= 当前元素自身最大 或者 包含 之前 后最大
        int max =nums[0];
        int pre =0;//之前的值
        for(int num:nums){
            pre = Math.max(num,pre+num);
            max = Math.max(max,pre);
        }
        return max;

    }
}