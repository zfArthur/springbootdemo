package com.example.demo.sf.sort;

/**
 * @Author zhangfu
 * @Date 2020-10-21 10:52
 */
public class BubbleSort {
    //冒泡排序
    //比较相邻的元素。如果第一个比第二个大，就交换它们两个；
    //对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
    //针对所有的元素重复以上的步骤，除了最后一个
    //重复步骤1~3，直到排序完成。
    public static void main(String[] args){
        int[] aa = {4,6,7,1,0,9,3};
        int len = aa.length;
        //外层控制比较的总论数,对于一个长度为N的数组，我们需要排序 N-1 轮
        for (int i = 0; i <len-1 ; i++) {
            //内层控制每轮比较的次数,每 i 轮 要比较 N-i 次,且第一次
            for (int j = 0; j < len-1-i; j++) {
                if (aa[j]>aa[j+1]){
                    int temp = aa[j];
                    aa[j] = aa[j+1];
                    aa[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }

    }
}
