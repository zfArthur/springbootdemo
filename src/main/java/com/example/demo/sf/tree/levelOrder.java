package com.example.demo.sf.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 102. 二叉树的层序遍历
 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
 空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
 */
public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        //边界条件判断
        if (root == null) {
            return ret;
        }
        //声明存储节点的queue 先进先出
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点入队
        queue.offer(root);
        //如果处理当前层的队列,不为空时
        while (!queue.isEmpty()) {
            //当前层的节点的值list
            List<Integer> level = new ArrayList<Integer>();
            //队列长度
            int currentLevelSize = queue.size();
            //循环当前队列取出本层的元素
            for (int i = 1; i <= currentLevelSize; ++i) {
                //出队
                TreeNode node = queue.poll();
                //存入当前层的节点的值list
                level.add(node.val);
                //将下一层左子树的元素存入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                //将下一层右子树的元素存入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //将本层的节点的值list存入结果集中
            ret.add(level);
        }

        return ret;
    }
}
