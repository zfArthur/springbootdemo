package com.example.demo.sf.dp;

/**
 * 1143. 最长公共子序列
 https://leetcode-cn.com/problems/longest-common-subsequence/
 */
/*
思维重点是把两个字符串转化为二维数组，然后进行dp
dp方程推导:

1.
S1 = “”
S2 = 任意字符串
2.
S1 =“A” S2 = 任意
3.
S1 =“.......A” S2 = “.....A”

dp方程为:
如果S1和 S2的末尾字母不相等时,取 S1-1,S2  S2-1,S1 中的最大值:
If S1[-1] != S2[-1]: LCS[s1, s2] = Max(LCS[s1-1, s2], LCS[s1, s2-1])

如果S1和 S2的末尾字母相等时,取 S1-1,S2-1的值加1
If S1[-1] == S2[-1]: LCS[s1, s2] = LCS[s1-1, s2-1] + 1

* */
public class longestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        //临界条件判断
        if(text1.length()==0||text2.length()==0) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        //从1开始，所以dp数组长度加一
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
