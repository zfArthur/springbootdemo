package com.example.demo.sf.kuohao;

/**
 * @Author zhangfu
 * @Date 2020-09-08 18:45
 */
public class generateParenthesis {

    public static void main(String[] args) {

//        Main.generate2(3);
//        Solution solution = new Solution();
//        System.out.println(solution.generateParenthesis(3));
    }

    // System.out.println(sum);

    //1. 题目分析: 可以想象往每个格子里放一个 ( 或者 ) ,在这里是 数字 n 代表生成括号的对数, 则总共可放括号的格子为2n个格子
    //2. 第一步套用递归模板
    /*

    public void recur(int level,int param){
    //递归终止条件
    if (level>MAX_LEVEL){
        // process result
        return;
    }
    // process current logic 本层逻辑处理
    process(level, param);

    // drill down 跳到下一层递归中
    recur( level: level + 1, newParam);

    //// restore current status
    //清理当前层的参数
    }
     */
    //3. 初始参数  level =1 即从第一个格子开始遍历, max 为最大的格子 2n  param为每次递归后的括号字符串
    public static String generate1(int n) {
        generateParenthesis._generate1(1,2*n,"");
        return null;
    }
    //4.不考虑括号的合法性，把所有的括号遍历出来
    public static void  _generate1(int level, int max, String s) {
        //终止条件
        if (level>max){
            System.out.println(s);
            return;
        }
        //本层逻辑处理
        //增加左括号 增加右括号
        String left = s+"(";
        String right = s+")";
        //进入下一层
        _generate1(level+1,max,left);
        _generate1(level+1,max,right);
        //本层参数清除
    }
    //递归状态树
    /*
初始：s=""；

           ""
        /       \         level =1
      "("       ")"
      /  \     /   \      level =2
   "(("  "()" ")("  "))"
    ...............
     */


    //5. 进一步思考看看能不能在括号生成的时候就校验合法性，将无用的括号过滤掉
    //6. 括号生成的条件:
    // 左括号随意加只要它不超标即可，即 left个数< n 代表生成括号的对数
    // 右括号增加前必须要有个左括号垫背, 即 left个数 > right个数


    public  static void  generate2(int n) {
        generateParenthesis._generate2(0,0,n,"");
    }
    //4.不考虑括号的合法性，把所有的括号遍历出来
    public static void  _generate2(int left,int right, int n, String s) {
        //终止条件 左括号和右括号个数达到n 代表生成括号的对数，即停止
        if (left==n && right==n){
            System.out.println(s);
            return;
        }
        //本层逻辑处理
        //增加左括号
        if (left<n){
            String leftStr = s+"(";
            _generate2(left+1,right,n,leftStr);
        }
        //增加右括号
        if (right<left){
            String rightStr = s+")";
            _generate2(left,right+1,n,rightStr);
        }
    }
}


//完整的答案

//class Solution {
//    private List<String> resList;
//    public List<String> generateParenthesis(int n) {
//        resList = new ArrayList<>();
//        _generate2(0, 0, n, "");
//        return resList;
//    }
//    //4.不考虑括号的合法性，把所有的括号遍历出来
//    public void  _generate2(int left,int right, int n, String s) {
//        //终止条件 左括号和右括号个数达到n 代表生成括号的对数，即停止
//        if (left==n && right==n){
//            resList.add(s);
//        }
//        //本层逻辑处理
//        //增加左括号
//        if (left<n){
//            String leftStr = s+"(";
//            _generate2(left+1,right,n,leftStr);
//        }
//        //增加右括号
//        if (right<left){
//            String rightStr = s+")";
//            _generate2(left,right+1,n,rightStr);
//        }
//    }
//}