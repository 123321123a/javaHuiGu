package jin.yuan.网络编程.test06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"all"})
public class 服务端 {
   public static void main(String[] args) throws  Exception{
      ServerSocket serverSocket = new ServerSocket(9999);
      Socket socket = serverSocket.accept(); //等待客户端连接
      //读取客户端放的要下载的文件名
      InputStream inputStream = socket.getInputStream();
      byte[] bytes = new byte[1024];
      int readLen = 0;
      String downLoadName = null; //下载的文件名
      while ((readLen = inputStream.read(bytes))!=-1){
         downLoadName = new String(bytes,0,readLen);
      }

      String resFileName = "";
      if ("01".equals(downLoadName)){
         resFileName = "/Users/jinyanping/Desktop/一堆破烂/01.jpg";
      }else resFileName = "/Users/jinyanping/Desktop/一堆破烂/02.jpg";

      // 创建一个输入流读取文件
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));

      // 读取文件到字节数组
      byte[] bytesData = StreamUtils.streamToByteArray(bis);

      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
      bufferedOutputStream.write(bytesData);
      socket.shutdownOutput();//写入结束

      bufferedOutputStream.close();
      bis.close();
      inputStream.close();
      socket.close();
      serverSocket.close();
   }
}
