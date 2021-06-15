package jin.yuan.网络编程.test02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings({"all"})
public class 客户端 {
   public static void main(String[] args) throws Exception {
      Socket socket = new Socket(InetAddress.getLocalHost(),9999);
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("hello 服务端".getBytes());

      //设置写入的结束标记
      socket.shutdownOutput();

      //获取和 Socket 相关联的输入流，读取数据（字节）
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int readLen = 0;
      while ((readLen = inputStream.read(bytes)) != -1){
         System.out.println(new String(bytes,0,readLen));
      }
      System.out.println("客户端退出");
      socket.close();
      inputStream.close();
      outputStream.close();
   }
}
