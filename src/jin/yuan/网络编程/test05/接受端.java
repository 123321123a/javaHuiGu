package jin.yuan.网络编程.test05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class 接受端 {
   public static void main(String[] args) throws Exception {
      // 1.创建一个 DatagramSocket 对象，准备在 9999 接受数据
      DatagramSocket socket = new DatagramSocket(9999);
      // 2.创建一个 DatagramPacket 对象，准备接受数据
      byte[] bytes = new byte[1024];
      DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

      // 3.准备调用接收方法，将通过网络传输的 DatagramPacket 对象填充到 datagramPacket 对象
      // 当有数据包发送到 这个端口时就会接收到数据，没有机会阻塞等待
      socket.receive(datagramPacket);

      // 4.可以把 datagramPacket 进行拆包，取出数据，并显示
      int length = datagramPacket.getLength(); //实际接受到的数据字节长度
      byte[] data = datagramPacket.getData();
      String s = new String(data, 0, length);
      System.out.println(s);

      // 5.接受端回复数据 好的,明天见
      byte[] bytes1 = "好的,明天见".getBytes();
      DatagramPacket packet = new DatagramPacket(bytes1, bytes1.length, InetAddress.getLocalHost(), 9998);
      socket.send(packet);

      // 6. 关闭资源
      socket.close();
   }
}
