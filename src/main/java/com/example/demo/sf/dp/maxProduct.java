package com.example.demo.sf.dp;

/**
 https://leetcode-cn.com/problems/maximum-product-subarray/
 152. 乘积最大子数组

 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

  

 示例 1:

 输入: [2,3,-2,4]
 输出: 6
 解释: 子数组 [2,3] 有最大乘积 6。
 示例 2:

 输入: [-2,0,-1]
 输出: 0
 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 */
public class maxProduct {
    public int maxProduct(int[] nums) {
        //动态规划,思路类似 53. 最大子序和 = 当前元素自身最大 或者 包含之前后最大
        //dp: 遍历数组时计算当前最大值，不断更新
        //令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
//由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
//当负数出现时则imax与imin进行交换再进行下一步计算
//时间复杂度：O(n)

        int max = Integer.MIN_VALUE;
        int imin = 1;
        int imax = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imin = Math.min(imin*nums[i],nums[i]);
            imax = Math.max(imax*nums[i],nums[i]);
            max = Math.max(imax,max);
        }
        return max;

    }
}
