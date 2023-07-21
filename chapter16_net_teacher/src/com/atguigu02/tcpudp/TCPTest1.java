package com.atguigu02.tcpudp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TCPTest1
 * Description:
 * 例题1：客户端发送内容给服务端，服务端将内容打印到控制台上。
 *
 * @Author 尚硅谷-宋红康
 * @Create 9:24
 * @Version 1.0
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 创建一个Socket
            InetAddress inetAddress = InetAddress.getByName("192.168.21.107"); //声明对方的ip地址
            int port = 8989;//声明对方的端口号
            socket = new Socket(inetAddress, port);

            //2. 发送数据
            os = socket.getOutputStream();
            os.write("你好，我是客户端，请多多关照".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭socket、关闭流
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null; //阻塞式的方法
        InputStream is = null;
        try {
            //1. 创建一个ServerSocket
            int port = 8989;
            serverSocket = new ServerSocket(port);

            //2. 调用accept()，接收客户端的Socket
            socket = serverSocket.accept();
            System.out.println("服务器端已开启");

            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的连接");

            //3. 接收数据
            is = socket.getInputStream();
            byte[] buffer = new byte[5];
            int len;
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); //内部维护了一个byte[]
            while ((len = is.read(buffer)) != -1) {
                //错误的，可能会出现乱码。
//                String str = new String(buffer, 0, len);
//                System.out.print(str);

                //正确的
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
            System.out.println("\n数据接收完毕");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭Socket、ServerSocket、流
            try {
                if (socket != null) {
                    socket.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //自己写的demo 和上面没关系FileInputStream he FileoutputStream
    @Test
    public void test03()throws IOException{
        // 使用文件名称创建流对象.
        FileInputStream fis = new FileInputStream("read.txt"); // 文件中为abcde
        // 定义变量，作为有效个数
        int len;
        // 定义字节数组，作为装字节数据的容器
        byte[] b = new byte[2];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //内部维护了一个byte[]
        // 循环读取
        while (( len= fis.read(b))!=-1) {
            // 每次读取后,把数组变成字符串打印
//            System.out.println(new String(b,0,len));

            baos.write(b,0,len); //更好
        }
//        byte[] byteArray = baos.toByteArray(); //可以转回数组
//        System.out.println(new String(byteArray));
        System.out.println(baos);

        // 关闭资源
        fis.close();
        /*
        输出结果：
        ab
        cd
        ed
        最后错误数据`d`，是由于最后一次读取时，只读取一个字节`e`，数组中，
        上次读取的数据没有被完全替换，所以要通过`len` ，获取有效的字节
         */
    }

    @Test
    public void myoutput() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("s.txt",true);
        String str="qqqqasaaadaaf";
        byte[] bytes = str.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.flush();



    }



}


