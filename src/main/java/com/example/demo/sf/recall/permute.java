package com.example.demo.sf.recall;

//回溯算法模板

//        result = []
//def backtrack(路径, 选择列表):
//    if 满足结束条件:
//        result.add(路径)
//        return
//
//    for 选择 in 选择列表:
//        做选择
//        backtrack(路径, 选择列表)
//        撤销选择

//第一种练习

//全排列 dfs+回溯模板练习
/*
public List<List<Integer>> permute(int[] nums) {
        //结果集
        List<List<Integer>> result = new ArrayList<>();
        //边界条件判断
        if (nums==null||nums.length==0) return result;
        //路径
        Deque<Integer> path = new ArrayDeque<>(nums.length);
        //是否访问过标识
        boolean[] visited = new boolean[nums.length];
        backtrack(0,path,nums,result,visited);
        return result;
        }

public void backtrack(int depth,Deque<Integer> path,int[] nums,List<List<Integer>> result,boolean[] visited){
        //满足递归终止条件
        if(depth==nums.length){
        result.add(new ArrayList<>(path));
        return;
        }
        for (int i=0; i<nums.length;i++) {
        //之前没有被选择过
        if (!visited[i]){
        //做选择
        path.addLast(nums[i]);
        visited[i]=true;
        //下跳到下一层
        backtrack(depth+1,path,nums,result,visited);
        //撤销选择
        path.removeLast();
        visited[i]=false;
        }
        }
        }

 */

//借鉴别人的思路

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

//题意理解 注意选择和撤销是递归前后的一对操作
//见图 permute.jpeg

//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        // 使用一个动态数组保存所有可能的全排列
//        List<List<Integer>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//
//        boolean[] used = new boolean[len];
//        Deque<Integer> path = new ArrayDeque<>(len);
//
//        dfs(nums, len, 0, path, used, res);
//        return res;
//    }
//    private void dfs(int[] nums, int len, int depth,
//                     Deque<Integer> path, boolean[] used,
//                     List<List<Integer>> res) {
//        if (depth == len) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        System.out.println("  递归了 depth => " + depth);
//        for (int i = 0; i < len; i++) {
//            System.out.println("  for----i => " + i);
//            if (!used[i]) {
//                path.addLast(nums[i]);
//                used[i] = true;
//
//                System.out.println("  递归之前 => " + path + "  i1=> "+i);
//                dfs(nums, len, depth + 1, path, used, res);
//                System.out.println("  递归了 depth => " + depth);
//                System.out.println("递归完了 => " + path+ "  i2=> "+i);
//                //还是不明白它是为啥是撤销了2次，代码里也没看到在dfs下有循环的痕迹,也只有一次撤销动作
//                //因为for里面嵌套了又一层dfs
//                used[i] = false;
//                path.removeLast();
//                System.out.println("递归之后 => " + path+ "  i3=> "+i);
//            }
//        }
//    }