package jin.yuan.网络编程.test05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 发送端 {
   public static void main(String[] args) throws Exception {
      // 1.创建 DatagramSocket 对象，准备在 9998 端口 发送数据
      DatagramSocket socket = new DatagramSocket(9998);

      // 2.将需要发送的数据封装到 DatagramPacket
      byte[] bytes = "hello 明天吃火锅".getBytes();
      DatagramPacket datagramPacket =
              new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
      socket.send(datagramPacket);

      //3. 接受回复的信息
      byte[] bytes1 = new byte[1024];
      DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
      socket.receive(datagramPacket1);
         //拆包，取出数据，并显示
      int length = datagramPacket1.getLength();
      byte[] data = datagramPacket1.getData();
      System.out.println(new String(data,0,length));

      //关闭资源
      socket.close();
      System.out.println("发送端退出...");
   }
}
