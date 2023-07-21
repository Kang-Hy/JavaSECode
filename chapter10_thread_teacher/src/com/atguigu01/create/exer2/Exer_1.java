package com.atguigu01.create.exer2;

/**
 * ClassName: Exer_1
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 12:00
 * @Version 1.0
 */
public class Exer_1 {
    public static void main(String[] args) {
        BB b = new BB();
        Thread thread = new Thread(b);
        Thread thread2 = new Thread(b);

        thread.start();
        thread2.start(); //两个线程使run 就可以在run里使用Thread.currentThread().XXXXXX(); 因为在每时不确定是哪个线程在运行
//        new Thread(b){
////            @Override
////            public void run() {
////                System.out.println("CC");
////            }
//        }.start();

//        new Thread(){}.start();

    }
}

class AA extends Thread{
    @Override
    public void run() {
        System.out.println("AA");

    }
}

class BB implements Runnable{
    @Override
    public void run() {
        System.out.println("BB");
    }
}
