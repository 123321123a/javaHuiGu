package jin.yuan.网络编程.多用户通讯系统.客户端.service;

import java.util.HashMap;

// 该类管理客户端连接到服务端的线程的类
public class ManageClientConnectServerThread {
   //把多个线程放入到 HashMap 集合，key 就是用户的 id，value就是线程
   private static HashMap<String,ClientConnectServerThread> hm = new HashMap<>();

   // 将某个线程加入到集合中
   public static void  addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
      hm.put(userId,clientConnectServerThread);
   }

   //取出线程
   public static ClientConnectServerThread getClientConnectServerThread(String userId){
      return hm.get(userId);
   }


}
