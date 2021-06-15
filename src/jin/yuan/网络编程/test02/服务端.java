package jin.yuan.网络编程.test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


@SuppressWarnings({"all"})
public class 服务端 {
   public static void main(String[] args) throws Exception {
      ServerSocket serverSocket = new ServerSocket(9999);
      System.out.println("服务端在端口进行监听...");
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int readLen = 0;
      //读取到数据
      while ((readLen = inputStream.read(bytes))  != -1){
         System.out.println(new String(bytes,0,readLen));
      }

      //写出数据
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("hello 客户端".getBytes());
      //设置写入的结束标记
      socket.shutdownOutput();
      System.out.println("服务端退出..");
      serverSocket.close();
      socket.close();
      inputStream.close();
      outputStream.close();
   }
}
