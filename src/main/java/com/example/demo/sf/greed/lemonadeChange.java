package com.example.demo.sf.greed;

/**
 860. 柠檬水找零
 https://leetcode-cn.com/problems/lemonade-change/
 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。

 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。

 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。

 注意，一开始你手头没有任何零钱。

 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

 示例 1：

 输入：[5,5,5,10,20]
 输出：true
 解释：
 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 由于所有客户都得到了正确的找零，所以我们输出 true。
 示例 2：

 输入：[5,5,10]
 输出：true
 示例 3：

 输入：[10,10]
 输出：false
 示例 4：

 输入：[5,5,10,10,20]
 输出：false
 解释：
 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 由于不是每位顾客都得到了正确的找零，所以答案是 false。


 提示：

 0 <= bills.length <= 10000
 bills[i] 不是 5 就是 10 或是 20
 */

public class lemonadeChange {
    //写法一: 贪心算法,即优先匹配最大的
    //时间复杂度：O(N)，其中 N是 bills 的长度。
    //空间复杂度：O(1)。
    public boolean lemonadeChange(int[] bills) {
        int fiveCount=0;
        int tenCount=0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5){
                fiveCount++;
            }else if(bills[i]==10) {
                //10的情况直接消耗一个5，先看一下5的个数是否大于0,小于0直接返回false
                if (fiveCount==0) return false;
                fiveCount--;
                tenCount++;
            }else {
                //无论是10还是20都要消耗5,先看一下5的个数是否大于0,小于0直接返回false
                if (fiveCount==0) return false;
                //当10的个数大于0时优先消耗10,每次消耗1个10和一个5
                if (tenCount>0){
                    fiveCount--;
                    tenCount--;
                }else{
                    //当10的个数小于0时,则需要全部消耗5,先看看是否有3个5能被消耗
                    if (fiveCount-3<0) return false;
                    fiveCount= fiveCount-3;
                }
            }
        }
        return true;
    }

    //写法二: 贪心算法,即优先匹配最大的
    //时间复杂度：O(N)，其中 N是 bills 的长度。
    //空间复杂度：O(1)。
    public boolean lemonadeChange1(int[] bills) {
        int fiveCount=0;
        int tenCount=0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i]==5){
                fiveCount++;
            }else if(bills[i]==10) {
                //10的情况直接消耗一个5，先看一下5的个数是否大于0,小于0直接返回false
                if (fiveCount==0) return false;
                fiveCount--;
                tenCount++;
            }else {
                //当10和5都有的时候消耗他们,1个10，1个5
                if (tenCount>0&&fiveCount>0){
                    fiveCount--;
                    tenCount--;
                }else if(fiveCount>3){
                    //当10没有时消耗5，且因为每次消耗3个5，要保证剩余5的个数大于3
                    fiveCount-=3;
                }else {
                    //都不满足消费条件时返回false
                    return false;
                }
            }
        }
        return true;
    }

}

