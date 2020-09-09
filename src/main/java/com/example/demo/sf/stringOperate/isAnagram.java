package com.example.demo.sf.stringOperate;

import java.util.Arrays;

/**
 *
 242. 有效的字母异位词
 https://leetcode-cn.com/problems/valid-anagram/

 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。

 */
public class isAnagram {

    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
    //判断依据 字母异位词: 两个字符串长度相等,字符串里的字母出现次数一样
    //解法一 将字符串排序后进行比较
    //复杂度分析
    //
    //时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlogn)。
    //空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1) 辅助空间。注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：这依赖于语言的细节。这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
    public  boolean isAnagram1(String s, String t) {
        //判断两个字符串的长度
        if (s.length()!= t.length()){
            return false;
        }
        //排序两个字符串
        char sch[] = s.toCharArray();
        char tch[] = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        //比较两个字符串数组
        return Arrays.equals(sch,tch);
    }

    //解法二 哈希表 将字符串排序后进行比较
    //思路: 为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 S 和 T 都只包含 A−Z 的字母，所以一个简单的 26 位计数器表就足够了。
    //我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
    //时间复杂度: O(n) 因为访问计数器表是一个固定的时间操作
    //空间复杂度：O(1) 尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 NN 有多大，表的大小都保持不变。
    public  boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];//因为 S 和 T 都只包含 A−Z 的字母，所以一个简单的 26 位计数器表就足够了
        for (int i = 0; i < s.length(); i++) {
            //因为 S 和 T 都只包含 A−Z 的字母,同时字母对应的就是asic码值,所有可以用asic码值来代替字母,然后字母出现一次计数+1
            counter[s.charAt(i) - 'a']++;
            //因为S和T中字母出现的次数一样，则这里对字母计数-1, 最终如果所有的字母计数都归0了，说明他们字母出现的次数一样，即是字母异位词
            counter[t.charAt(i) - 'a']--;
        }
        for (int count: counter) {
            if (count!=0){
                return false;
            }
        }
        return true;
    }
    //更好点的写法
    //先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。
    //时间复杂度: O(n) 因为访问计数器表是一个固定的时间操作
    //空间复杂度：O(1) 尽管我们使用了额外的空间，但是空间的复杂性是 O(1)，因为无论 NN 有多大，表的大小都保持不变。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    //进阶：
    //如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
    //解答：
    //使用哈希表而不是固定大小的计数器。想象一下，分配一个大的数组来适应整个 Unicode 字符范围，这个范围可能超过 100万。哈希表是一种更通用的解决方案，可以适应任何字符范围。
}
