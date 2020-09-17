package com.example.demo.sf.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**

 103. 二叉树的锯齿形层次遍历
 https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回锯齿形层次遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]

 */
//解法: bfs
// 处理技巧 depth%2 作为左右往复的标识位
// List可以向指定位置插入元素，这里是强行向首位不断追加元素,使后面的数据可以插到前面
// 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
// 空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //临界条件
        if (root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (depth%2==0){
                    tempList.add(node.val);
                }else {
                    tempList.add(0,node.val);
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(tempList);
            depth++;
        }
        return result;
    }
}
