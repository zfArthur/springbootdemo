package com.example.demo.sf.linkedList;

/**
 剑指 Offer 06. 从尾到头打印链表
 https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/

 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]


 限制：

 0 <= 链表长度 <= 10000

 */
/*
方法一：栈
栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置。从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。

创建一个栈，用于存储链表的节点
创建一个指针，初始时指向链表的头节点
当指针指向的元素非空时，重复下列操作：
将指针指向的节点压入栈内
将指针移到当前节点的下一个节点
获得栈的大小 size，创建一个数组 print，其大小为 size
创建下标并初始化 index = 0
重复 size 次下列操作：
从栈内弹出一个节点，将该节点的值存到 print[index]
将 index 的值加 1
返回 print

复杂性分析
时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。
* */

//栈中存节点的值

//class reversePrint {
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> myStack = new Stack<>();
//        ListNode temp = head;
//        while (temp!=null){
//            myStack.add(temp.val);
//            temp = temp.next;
//        }
//        int ans[] = new int[myStack.size()];
//        int index=0;
//        while (!myStack.empty()){
//            ans[index++]=myStack.pop();
//        }
//        return ans;
//    }
//}

// 栈中存节点

//class reversePrint {
//    public int[] reversePrint(ListNode head) {
//        Stack<Integer> myStack = new Stack<>();
//        ListNode temp = head;
//        while (temp!=null){
//            myStack.add(temp);
//            temp = temp.next;
//        }
//        int ans[] = new int[myStack.size()];
//        int index=0;
//        while (!myStack.empty()){
//            ans[index++]=myStack.pop().val;
//        }
//        return ans;
//    }
//}