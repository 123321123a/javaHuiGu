package jin.yuan.网络编程;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 服务端
public class b_TcpServer {
   public static void main(String[] args) throws IOException {

      //监听 19999 端口
      ServerSocket serverSocket = new ServerSocket(19999);
      System.out.println("init serverSocket");
      Socket socket = serverSocket.accept(); //等着人进来，如果有人进来，才会执行这句话
      //接受数据
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int num = 0;
      while ((num = inputStream.read(bytes)) != -1){
         System.out.println(new String(bytes, 0, num));
      }

      //服务器回复消息
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write("i am a fwq" .getBytes());
      socket.shutdownInput();

      //关闭（先开后关）
      inputStream.close();
      socket.close();
      serverSocket.close();
   }

}
