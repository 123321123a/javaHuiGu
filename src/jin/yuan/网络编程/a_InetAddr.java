package jin.yuan.网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class a_InetAddr {

   public static void main(String[] args) throws UnknownHostException {
      //InetAddress 类是 IP地址 和 域名 相互转换的类
      // 根据指定的  主机名/域名 获取 InetAddress 对象
      InetAddress byName = InetAddress.getByName("www.baidu.com");
      String hostAddress = byName.getHostAddress();
      System.out.println("百度的IP地址：" + hostAddress); //百度的IP地址：36.152.44.96

      // 获取本机的 InetAddress 对象
      InetAddress localHost = InetAddress.getLocalHost();
      String hostAddress1 = localHost.getHostAddress();
      System.out.println("本机的IP地址：" + hostAddress1); //本机的IP地址：127.0.0.1

      // 通过 InetAddress 对象，获取对应的地址
      String hostAddress2 = localHost.getHostAddress();
      System.out.println(hostAddress2); //127.0.0.1

      // 通过 InetAddress 对象，获取主机名 / 域名
      String hostName = byName.getHostName();
      System.out.println(hostName); //www.baidu.com
   }
}
