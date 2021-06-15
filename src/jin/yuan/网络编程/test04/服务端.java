package jin.yuan.网络编程.test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class 服务端 {
   public static void main(String[] args) throws Exception {
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("服务端在监听 .....");
      Socket socket = serverSocket.accept();

      // 读取客户端发送的数据
      BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
      byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream); //拿到 图片的字节数组
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/jinyanping/Downloads/code/JavaWork/java回顾/src/jin/yuan/网络编程/test04/02.jpg"));
      bufferedOutputStream.write(bytes); //保存到目录下

      // 向客户端回复收到的图片
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      bufferedWriter.write("收到图片");
      bufferedWriter.flush();
      socket.shutdownOutput(); //写入结束标记

      System.out.println("结束了");
      bufferedWriter.close();
      bufferedOutputStream.close();
      bufferedInputStream.close();
      socket.close();
      serverSocket.close();
   }
}
