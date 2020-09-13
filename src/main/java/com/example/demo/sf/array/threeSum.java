package com.example.demo.sf.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhangfu
 * @Date 2020-09-12 21:25
 */
public class threeSum {
    //https://leetcode-cn.com/problems/3sum/

    //双指针法
    //时间复杂度O(n2)
    /*复杂度分析：
        时间复杂度 O(N^2)
        2)：其中固定指针k循环复杂度 O(N)，双指针 i，j 复杂度 O(N)。
        空间复杂度 O(1)：指针使用常数大小的额外空间。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //数组排序 nO(logn)
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < len - 2; k++) {
            //因为数组排序了，nums[j] >= nums[i] >= nums[k] > 0,即 3 个数字都大于 0 ，在此固定指针 k 之后不可能再找到结果了
            if (nums[k] > 0) break;
            //当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = len - 1;
            while (i < j) {
                //三数相加
                int sum = nums[k] + nums[i] + nums[j];
                //int[] nums = {-4,-1,-1,-1,0,1,2};
                if (sum < 0) {
                    //证明i的值比较小，需要向右移动i，并跳过所有重复的nums[i]
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    //证明j的值比较大，需要向左移动j,并跳过所有重复的nums[j]
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //向右移动i
                    while (i < j && nums[i] == nums[++i]) ;
                    //向左移动i
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return ans;
    }
}