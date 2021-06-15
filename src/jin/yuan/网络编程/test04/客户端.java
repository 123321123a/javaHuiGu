package jin.yuan.网络编程.test04;

import org.junit.Before;

import javax.lang.model.element.VariableElement;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class 客户端 {
   public static void main(String[] args) throws  Exception{
      Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
      // 创建读取磁盘的输入流
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/jinyanping/Desktop/一堆破烂/01.jpg"));
      byte[] bytes = StreamUtils.streamToByteArray(bis); // 这里就是文件的内容

      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
      bufferedOutputStream.write(bytes); //将文件对应的字节数组，写入到数据通道
      socket.shutdownOutput(); //设置写入数据的结束标记

      //获取从服务端回复的消息
      String s = StreamUtils.streamToString(socket.getInputStream());
      System.out.println(s);
      bis.close();
      bufferedOutputStream.close();
      socket.close();
   }
}
