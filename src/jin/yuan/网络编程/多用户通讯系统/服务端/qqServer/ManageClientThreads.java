package jin.yuan.网络编程.多用户通讯系统.服务端.qqServer;

import java.util.HashMap;

// 该类用于管理和客户端通讯的线程
public class ManageClientThreads {
   private static HashMap<String,ServerConnectClientThread> hm = new HashMap<>();
   public static void addClientThread (String userId,ServerConnectClientThread serverConnectClientThread){
      hm.put(userId,serverConnectClientThread);
   }
   public static ServerConnectClientThread getClientThread(String userId){
      return hm.get(userId);
   }

   //返回在线用户列表
   public static String getOnLineUser(){
      StringBuilder onLineList = new StringBuilder();
      for (String s : hm.keySet()) {
         onLineList.append(s).append(" ");
      }
      return String.valueOf(onLineList);
   }

   //从集合中删除某个线程对象
   public static void removeServerConnectClientThread(String userId){
      hm.remove(userId);
   }
}
