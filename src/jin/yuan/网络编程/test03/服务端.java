package jin.yuan.网络编程.test03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class 服务端 {
   public static void main(String[] args) throws Exception {
      ServerSocket serverSocket = new ServerSocket(9999);
      System.out.println("服务端在端口进行监听...");
      Socket socket = serverSocket.accept();
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String s = reader.readLine();
      System.out.println(s);

      //写出数据
      OutputStream outputStream = socket.getOutputStream();
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
      writer.write("hello 客户端");
      writer.newLine();//表示写入的回复内容结束
      writer.flush();


      //设置写入的结束标记
      socket.shutdownOutput();
      System.out.println("服务端退出..");
      serverSocket.close();
      socket.close();
      reader.close();
      writer.close();
   }
}
