package com.example.demo.sf.stringOperate;

/**
 剑指 Offer 05. 替换空格
 https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 示例 1：

 输入：s = "We are happy."
 输出："We%20are%20happy."

 限制：

 0 <= s 的长度 <= 10000
 */

class replaceSpace {

    //解法一 StringBuilder
   // 时间复杂度是 O(n)
    //空间复杂度是 O(n)
    public String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    //简洁写法
    //缺点： 熟悉 StringBuilder 的朋友，应该知道它本质上是一个 char 类型的动态数组：
    //当初始化 StringBuilder 的时候，会初始化一个固定长度的 char 类型的数组
    //当往 StringBuilder 中 append 数据的时候，其实就是往 char 类型的数组最后追加数据
    //那么，当追加的数据的个数超过了数组的大小的时候，就需要对 char 类型的数据进行扩容了，所以这里的扩容还是有点性能损耗的，那么我们能不能减少这个性能损耗呢？
    //答案是可以的，我们可以通过使用静态数组来解决这个问题，从而可以消除数组动态扩容带来的性能损耗

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch:s.toCharArray()) {
            if (ch==' '){
                sb.append("%20");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //解法二 现有函数 replaceAll
    public String replaceSpace2(String s) {

        return s.replaceAll(" ", "%20");

    }
}
