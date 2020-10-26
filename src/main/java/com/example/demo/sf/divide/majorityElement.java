package com.example.demo.sf.divide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 https://leetcode-cn.com/problems/majority-element/
 */
public class majorityElement {
    //排序法 O(nlogn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    //哈希表 O(n)
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        double l = len;
        double halfn = l/2;
        Map<Integer,Integer> cou = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int countN = cou.getOrDefault(nums[i],0)+1;
            if (countN>halfn) return nums[i];
            cou.put(nums[i],countN);
        }
        return 0;
    }


}
