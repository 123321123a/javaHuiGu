package jin.yuan.网络编程.test;

import sun.tools.jstat.Scale;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class 客户端 {
   public static void main(String[] args) throws Exception {
      //连接服务端（IP，端口），返回 Socket 对象
      Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
      //连接上后，生成 Socket 通过Socket，获取输入流，写入到数据通道
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("hello 金源".getBytes());
      //关闭对象和 Socket
      outputStream.close();
      socket.close();
   }
}
