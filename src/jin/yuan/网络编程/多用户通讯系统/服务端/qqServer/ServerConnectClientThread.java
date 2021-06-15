package jin.yuan.网络编程.多用户通讯系统.服务端.qqServer;

import jin.yuan.网络编程.多用户通讯系统.共有的.Message;
import jin.yuan.网络编程.多用户通讯系统.共有的.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// 该类对用的一个对象和某个客户端保持一个通讯
@SuppressWarnings({"all"})
public class ServerConnectClientThread extends Thread{
   private Socket socket;
   private String userId; // 为了区分这个 socket 是和哪个用户进行关联的

   public ServerConnectClientThread() {
   }

   public ServerConnectClientThread(Socket socket, String userId) {
      this.socket = socket;
      this.userId = userId;
   }

   public Socket getSocket() {
      return socket;
   }

   @Override
   public void run() {
      while (true){
         try {
            System.out.println("服务器端和客户端保持通讯..." + userId);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            // 拿到客户端的 Message 对象
            Message message = (Message)inputStream.readObject();
            if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
               //客户端要在线用户列表
               System.out.println(message.getSender() + " 要在线用户列表");
               String onLineUser = ManageClientThreads.getOnLineUser();
               Message message2 = new Message();
               message2.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
               message2.setContent(onLineUser);
               message2.setGetter(message.getSender());//发送者

               //返回给客户端
               ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
               outputStream.writeObject(message2);
            }else  if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
               //普通聊天类型
               ServerConnectClientThread clientThread = ManageClientThreads.getClientThread(message.getGetter());
               ObjectOutputStream outputStream = new ObjectOutputStream(clientThread.getSocket().getOutputStream());
               outputStream.writeObject(message); //转发，如果客户不在线，可以保存到数据库
            } else  if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
               //客户端要退出系统
               System.out.println(message.getSender() +" 退出");
               // 将这个客户端的线程从集合删除
               ManageClientThreads.removeServerConnectClientThread(message.getSender());
               socket.close();
               break;
            }
         } catch (Exception e) {
            e.printStackTrace();
         }

      }
   }
}
