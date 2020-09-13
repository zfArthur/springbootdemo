package com.example.demo.sf.kuohao;

import java.util.ArrayList;
import java.util.List;

/**
 78. 子集
 https://leetcode-cn.com/problems/subsets/
 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 */
public class subsets {

    //解法一: 类比括号生成问题的解法
    //1. 将整数数组 nums的每一个元素位想象为一个小格子
    //2. 然后开始往小格子里放元素，有两种放法 即此格子位放或者不放元素
    //3. 由此产生两种状态的类型了，然后依次递归
    //时间复杂度: O(n)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            //每次的递归的子集存放
            List<Integer> list = new ArrayList<>();
            //结果集
            List<List<Integer>> ans = new ArrayList<>();
            //生成子集的方法   level为0，即从数组的第一个元素开始
            this._subsets(0,nums,ans,list);
            return ans;
        }

        public void _subsets(int level,int[] nums, List<List<Integer>> ans,List<Integer> list) {
            //递归停止条件w
            if (level==nums.length){
                //符合条件的结果放入结果集中
                ans.add(new ArrayList<Integer>(list));
                return;
            }
            //本层处理
            //不放这个值
            //调到下一层
            _subsets(level+1,nums,ans,list);
            //放这个值
            list.add(nums[level]);
            //调到下一层
            _subsets(level+1,nums,ans,list);
            //本层数据清理
            list.remove(list.size()-1);
        }
    }


}
