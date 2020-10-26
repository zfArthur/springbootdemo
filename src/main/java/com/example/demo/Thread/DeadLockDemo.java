package com.example.demo.Thread;

/**
 * @Author zhangfu
 * @Date 2020-09-29 17:14
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args){
        new DeadLockDemo().deadLock();
    }
    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (A){
                   try {
                       Thread.currentThread().sleep(2000);
                       synchronized (B){
                           System.out.println("1");
                       }
                   }catch(InterruptedException e){
                       e.printStackTrace();
                   }
               }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
