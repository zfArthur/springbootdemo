package com.example.demo.sf.dp;

/**
 * @Author zhangfu
 * @Date 2020-10-04 21:52
 */
public class rob {

    //解法一
    //时间 O(n)
    //空间 O(n)
    public int rob1(int[] nums) {
        //dp方程推导
        // 0 不偷 1 偷
        // a[i][0,1] 0...i 代表能偷到的最大金额
        //a[i][0]=max(a[i-1][0],a[i-1][1])
        //a[i][1]=a[i-1][0]+nums[i]

        //临界条件判断
        if(nums==null||nums.length==0) return 0;
        int n = nums.length;
        int[][] a = new int[n][2];
        //初始化
        a[0][0] =0;
        a[0][1] =nums[0];
        //dp方程,0已经初始化了，从1开始
        for(int i=1;i<n;i++){
            a[i][0]=Math.max(a[i-1][0],a[i-1][1]);
            a[i][1]=a[i-1][0]+nums[i];
        }
        return Math.max(a[n-1][0],a[n-1][1]);
    }
    //解法二
    public int rob2(int[] nums) {
        // a[i] 0...i 代表能偷到的最大金额,第i个房子可偷可不偷
        // 如果不偷 a[i],则将a[i-1]的值挪过来，成为能偷到的最大值 ,
        // 偷a[i]的话则就不能在偷a[i-1]了，则需要将a[i-2]的值拿过来和当前偷的a[i]对应的值nums[i]相加,取这两者中的最大值即可
        // 为啥不是a[i-3],a[i-4] 因为a[i-2]已经将a[i-3]的情况包括了
        // a[i] = Math.max(a[i-1]+0,a[i-2]+nums[i])
        //临界条件判断
        int n = nums.length;
        if(n<=1) return n==0?0:nums[0];
        int[] dp = new int[n];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    //解法三:通过解法二dp方程: a[i] = Math.max(a[i-1],a[i-2]+nums[i]),
    // 发现跟f(n)=f(n-1)+f(n-2)类似,则我们可以只关注i-1 和i-2

    public int rob3(int[] nums) {
        int pre = 0;
        int now = 0;
        // 每次循环，计算“偷到当前房子为止的最大金额”
        // 循环开始时，now 表示 dp[i-1]，pre 表示 dp[i-2]
        // a[i] = Math.max(a[i-1],a[i-2]+nums[i])
        for (int num: nums) {
            int temp = Math.max(now,pre+num);
            pre = now;
            now = temp;
            // 循环结束时，now 表示 a[k]，pre 表示 a[k-1]
        }
        return now;
    }

    private int robSub(int[] nums,int start,int end) {
        int[] dp = new int[end-start+1];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start+1],nums[start]);
        for (int i = start+2; i <=end; i++) {
            dp[i-start] = Math.max(dp[i-start-1],dp[i-start-2]+nums[i]);
        }
        return dp[end-start];
    }
}
