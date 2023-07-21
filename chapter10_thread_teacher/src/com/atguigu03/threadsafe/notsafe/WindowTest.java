package com.atguigu03.threadsafe.notsafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: WindowTest
 * Description:
 *      使用实现Runnable接口的方式，实现卖票
 * @Author 尚硅谷-宋红康
 * @Create 15:19
 * @Version 1.0
 */

class SaleTicket implements Runnable{
    private final ReentrantLock rlock=new ReentrantLock();
    int ticket = 100;
    @Override
    public void run() {

        while(true){
            rlock.lock();
            if(ticket > 0){
                //模拟卖票

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket);
                ticket--;

            }else{
                rlock.unlock();
                break;
            }
            rlock.unlock();
        }

    }
}

public class WindowTest {
    public static void main(String[] args) {

        SaleTicket s = new SaleTicket();

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}
