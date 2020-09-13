package com.example.demo.sf.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangfu
 * @Date 2020-09-13 11:37
 */
public class majorityElement {

    public int majorityElement(int[] nums) {
        //哈希表法  将多数元素的标准 n/2 求出,循环记录元素出现的次数，当出现的次数大于n/2的时候将元素返回
        Map<Integer,Integer> count = new HashMap();
        for(int num:nums){
            //遍历到当前元素的时候要把当前这次加上在和  n/2对比
            if(count.getOrDefault(num,0)+1>Double.valueOf(nums.length)/2){
                return num;
            }else{
                count.put(num,count.getOrDefault(num,0)+1);
            }
        }
        throw new IllegalArgumentException("No majorityElement solution");
    }
}
