package com.example.demo.sf.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 515. 在每个树行中找最大值
 您需要在二叉树的每一行中找到最大的值。

 示例：

 输入:

 1
 / \
 3   2
 / \   \
 5   3   9

 输出: [1, 3, 9]
 https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 *  时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
 *  空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
 */
public class largestValues {

    public List<Integer> largestValues(TreeNode root) {
        //bfs模板
        //结果集
        //临界条件判断
        //声明存储每层元素的queue
        //root入队
        //queue不空循环处理queue
        //处理当前层的节点出队，保持队列为空，好放下一层的节点
        //将下一层的节点入队
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();//LinkedList也行
        queue.offer(root);
        while (!queue.isEmpty()){
            int currentsize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <currentsize ; i++) {
                TreeNode node=queue.poll();//注意这里是node,后续处理都是处理的这个node
                max = Math.max(max,node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
