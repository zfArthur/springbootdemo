package com.example.demo.sf.recall;


//回溯算法与深度优先遍历
//时间复杂度：O(N×N!)
//空间复杂度：O(N×N!)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class permute {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        //是否用到过的元素存储
        boolean[] used = new boolean[len];
        //路径全排列
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(0,len,nums,path,ans,used);
        return ans;
    }
    public void dfs(int level,int len, int[]nums,Deque<Integer> path,List<List<Integer>> ans,boolean[] used){
        //递归终止条件
        if(level == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        //本层逻辑处理
        //循环向格子里写元素
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                //调到下一层
                dfs(level+1,len,nums,path,ans,used);
                //回溯状态
                path.removeLast();
                used[i]=false;
            }
        }
    }
}