package com.atguigu05.other;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: OtherAPITest
 * Description:
 *
 * @Author 尚硅谷-宋红康
 * @Create 9:00
 * @Version 1.0
 */
public class OtherAPITest {
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }


    @Test
    public void test3() {
        //技巧：floor(x + 0.5)
        System.out.println(Math.round(12.3));//12
        System.out.println(Math.round(12.5));//13
        System.out.println(Math.round(-12.3));//-12
        System.out.println(Math.round(-12.6));//-13
        System.out.println(Math.round(-12.5));//-12

        //数据复制 从指定源数组中复制一个数组 没看得懂
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[10];
        System.arraycopy(arr1, 0, arr2, 2, arr1.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int[] arr = {1, 2, 3, 4, 5};
        //1
//        System.arraycopy(arr,0,arr,1,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        //2
        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test4() {
//        long bigNum = 123456789123456789123456789L;

        BigInteger b1 = new BigInteger("1234");
        BigInteger b2 = new BigInteger("12345");


//        System.out.println("和：" + (b1+b2));//错误的，无法直接使用+进行求和


        System.out.println("和：" + b1.add(b2));
        System.out.println("减：" + b1.subtract(b2));
        System.out.println("乘：" + b1.multiply(b2));
        System.out.println("除：" + b2.divide(b1));
        System.out.println("余：" + b2.remainder(b1));
    }

    @Test
    public void test5() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);//12433241123
//         System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, 5,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd);//12435.351
        System.out.println(bd2);//11

    }

    @Test
    public void test6() {
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);
        byte[] bytes = new byte[5];
        random.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        int j = random.nextInt(10); //随机获取[0,10)范围的整数
        System.out.println(j);


    }
    @Test
    public void w(){
//        Person p1 = new Person();
//        p1.name = "Tom";
//
//        Person p2 = new Person();
//        p2.name = "Tom";
//
//        System.out.println(p1.name.equals( p2.name)); //
//        System.out.println(p1.name == p2.name); //
//        System.out.println(p1.name == "Tom"); //

        String s1=new String("ab");
        String s2=s1.intern();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s2==s1);
    }

    class Person{
        String name;
    }

}

