package jin.yuan.网络编程.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class 服务端 {
   public static void main(String[] args) throws IOException {
      // 监听 9999 端口，等待连接
      // 细节：这个 ServerSocket 可以通过 accept() 返回读个 Socket【多并发】
      ServerSocket serverSocket = new ServerSocket(9999);
      // 通过Socket 获取输入流，写入数据显示
      Socket socket = serverSocket.accept(); //当有客户端连接，则会返回一个 Socket 对象，程序继续往下执行
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new  byte[1024];
      int readLen = 0;
      while ((readLen = inputStream.read(bytes)) != -1){
         // 根据读取到的实际长度显示内容
         System.out.println(new String(bytes,0,readLen));
      }

      inputStream.close();
      socket.close();
      serverSocket.close();
   }
}
