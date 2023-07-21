package com.atguigu01.create.exer1;/**
* ClassName: ConcurrentProblem
* Package: com.atguigu01.create.exer1
* Description:
* @Author 康海洋
* @Create 2023/7/14 11:15
* @Version 1.0
/**
 * 线程不安全案例：
 */
public class ConcurrentProblem implements Runnable {

     static ConcurrentProblem concurrentProblem = new ConcurrentProblem();
     static int count=0;
     static int count2=0;



    /**
     * 多线程问题原因：count++这行代码要分三步执行；1：读取；2：修改；3：写入。
     * 在这三步中，任何一步都可能被其他线程打断，导致值还没来得及写入，就被其他线程读取或写入，这就是多线程并行操作统一变量导致的问题。
     */
    @Override
    public void run() {
        for (int k = 0; k < 1000; k++) {
            count++;
            count2--;
            if (count+count2!=0){
                System.out.println("线程不安全");
                break;
            }
            System.out.println(Thread.currentThread().getName()+"------conunt1------="+count);
            System.out.println(Thread.currentThread().getName()+"------conunt2------="+count2);

        }
    }

}
class Test1{
    public static void main(String[] args) {



        Thread thread1 = new Thread(ConcurrentProblem.concurrentProblem);

        Thread thread2 = new Thread(ConcurrentProblem.concurrentProblem);

        thread1.start();
        thread2.start();
        try {
            // 等待两个线程都运行结束后，再打印结果
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //期待结果是20000，但是结果会小于这个值
        System.out.println(ConcurrentProblem.count);
        System.out.println(ConcurrentProblem.count2);
    }

}
