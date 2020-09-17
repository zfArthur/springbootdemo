package com.example.demo.sf.tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/*

 剑指 Offer 68 - II.二叉树的最近公共祖先
 https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

* */

/*
要看懂题意
解法一: 存储父节点法 + dfs递归
思路: 利用哈希表存储所有节点的父节点,然后利用节点的父节点信息从p节点开始不断地往上跳，并记录访问过的节点，
再从q节点开始不断地往上跳,如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先
算法:
1. 从根节点开始遍历（深度优先搜索dfs）整颗二叉树,用哈希表记录每个节点的父节点指针
2. 从p节点开始不断地往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
3. 同样从q节点开始不断地往它的祖先移动,如果有祖先已经被访问过了，那就意味着这就是p和q的深度最深的公共祖先，即lca节点
* */
//时间复杂度 O(n) n为树的节点数,需要遍历一遍树，同时p q 往上跳不会超过n,所有时间复杂是为n
//空间复杂度 O(n) n是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况为一条链，此时高度为n,因此空间复杂度为O(n),
// 哈希表存储每个节点的父节点也需要O(n)的时间复杂度，所有最后时间复杂度为O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class lowestCommonAncestor {

    Map<Integer,TreeNode> parent = new HashMap<Integer,TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    //遍历树将每个节点的父节点存起来
    public void dfs(TreeNode root){
        if (root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }

        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //遍历树将每个节点的父节点存起来
        dfs(root);
        //从p节点开始不断地往上跳，并记录访问过的节点，
        while (p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q!=null){
            //从q节点开始不断地往上跳,如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
