package com.example.demo.Thread;

/**
 * @Author zhangfu
 * @Date 2020-10-11 15:53
 */
public class repeatSortTest {
    static int x = 0;
    static int y = 0;
     static int  a = 0;
     static int  b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {

            public void run() {
                System.out.println("AAAA");
                a = 1;
                x = b;
            }
        });

        Thread B = new Thread(new Runnable() {
            public void run() {
                System.out.println("BBBB");
                b = 2;
                y = a;
            }
        });
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("(" + x + "," + y + ")");
    }
}
