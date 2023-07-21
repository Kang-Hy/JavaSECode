package com.atguigu01.create.exer2;

/**
 * 思考题：判断各自调用的是哪个run()？
 */
public class Exer {
    public static void main(String[] args) {
        A a = new A();
        Runnable a1=a;
        a1.run();
        System.out.println("11");


        a.start(); //① 启动线程 ② 调用Thread类的run()

        B b = new B(a);
        b.start();

    }
}

//创建线程类A
class A extends Thread {
    public A(){

    }
    @Override
    public void run() {
        System.out.println("线程A的run()...");

    }
}

//创建线程类B
class B extends Thread {
    private A a;


//    public B(A a) {//构造器中，直接传入A类对象
//        this.a = a;
//    }

    public B(A a){
        super(a); //传过去的是a 如果没有重写run就掉a的run
    }

//    @Override
//    public void run() {
//        System.out.println("线程B的run()...");
////        a.run();
//    }
}
