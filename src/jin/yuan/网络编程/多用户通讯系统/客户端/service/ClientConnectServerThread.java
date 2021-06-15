package jin.yuan.网络编程.多用户通讯系统.客户端.service;

import jin.yuan.网络编程.多用户通讯系统.共有的.Message;
import jin.yuan.网络编程.多用户通讯系统.共有的.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
   //该线程需要持有 Socket
   private Socket socket;

   public ClientConnectServerThread(Socket socket){
      this.socket = socket;
   }

   public Socket getSocket() {
      return socket;
   }

   public void setSocket(Socket socket) {
      this.socket = socket;
   }

   @Override
   public void run() {
      // 因为 Thread 需要在后台和服务器进行通讯，因此我们用一个 while 循环来控制
      while (true){
         System.out.println("客户端线程，等待从服务器端发来的信息");
         try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) inputStream.readObject(); //如果服务器没有发送 Message 对象，服务器会堵塞在这里
            //判断 massage 的类型，然后做响应的业务处理
            if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
               //返回的是在线用户列表
               String[] onlineUser = message.getContent().split(" ");
               System.out.println("===== 当前在线用户列表=====");
               for (String s : onlineUser) {
                  System.out.println("用户:" + s);
               }
            }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
               //把从服务器端转发的消息显示到控制台即可
               System.out.println("\n" + message.getSender() + " 对" + message.getGetter() + " 说" + message.getContent());
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}
