package jin.yuan.网络编程.test03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class 客户端 {
   public static void main(String[] args)throws Exception {
      Socket socket = new Socket(InetAddress.getLocalHost(),9999);
      OutputStream outputStream = socket.getOutputStream();
//      outputStream.write("hello 服务端".getBytes());

      // 通过字符流写入到数据通道
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
      writer.write("hello 字符流"); //如果使用的是字符流，需要手动刷新，否则数据不会写入到数据通道
      writer.newLine();//插入一个换行符，表示写入的内容结束 （ 注：要求对方使用 readLine() ）
      writer.flush();

      //获取和 Socket 相关联的输入流，读取数据（字节）
      InputStream inputStream = socket.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      String s = reader.readLine();
      System.out.println(s);

      System.out.println("客户端退出");
      socket.close();
      reader.close();
      writer.close();
   }
}
