package com.example.demo.sf.dp;

/**
 https://leetcode-cn.com/problems/house-robber-ii/
 213. 打家劫舍 II
 */

class rob2 {
    public int rob2(int[] nums) {
        //此题是在 打家劫舍1的基础上的拓展，我们的思路是把这个题目转化成为打家劫舍1来解决,
        //即分为2种情况,
        //不偷第一个, 只偷 2-->n个房间，这个子问题可以用 打家劫舍1来解决
        //不偷最后一个,只偷 1-->n-2个房间，这个子问题可以用 打家劫舍1来解决
        //然后在求出2次偷的中的最大值即可

        //临界条件判断
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        //只偷 2-->n个房间
        int temp1 = robSub(nums,1,nums.length-1);
        //只偷 1-->n-1个房间
        int temp2 = robSub(nums,0,nums.length-2);
        return Math.max(temp1,temp2);
    }

    private int robSub(int[] nums,int start,int end) {
        int[] dp = new int[end-start+1];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start+1],nums[start]);
        for (int i = start+2; i <=end; i++) {
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start];
    }
}