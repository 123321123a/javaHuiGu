package jin.yuan.网络编程.test06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class 客户端 {
   public static void main(String[] args) throws Exception{
      String fileName = new Scanner(System.in).next();
      Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(fileName.getBytes());
      //设置写入结束的标志
      socket.shutdownOutput();
      //读取服务端返回的数据
      BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
      byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/jinyanping/Downloads/code/JavaWork/java回顾/src/jin/yuan/网络编程/test06/03.jpg"));
      bufferedOutputStream.write(bytes);

      bufferedOutputStream.close();
      bufferedInputStream.close();
      socket.close();
      outputStream.close();
   }
}
