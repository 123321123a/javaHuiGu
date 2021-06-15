package jin.yuan.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

// 客户端
public class b_TcpClient {

   public static void main(String[] args) throws IOException {

      //连接到服务器
      InetAddress localhost = InetAddress.getByName("localhost");
      Socket socket = new Socket(localhost, 19999); //已经建立起来了连接

      //开始发送消息
      String msg =  "i am a student";
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(msg.getBytes());

      //接受服务器发送回来的数据
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int num = 0;
      while ((num = inputStream.read(bytes)) != -1){
         System.out.println(new String(bytes, 0, num));
      }

      socket.shutdownInput();//告诉对方我已经发送完数据了
      inputStream.close();
      outputStream.close();
      socket.close();
   }
}
