package jin.yuan.网络编程.多用户通讯系统.客户端.service;

import jin.yuan.网络编程.多用户通讯系统.共有的.Message;
import jin.yuan.网络编程.多用户通讯系统.共有的.MessageType;
import jin.yuan.网络编程.多用户通讯系统.共有的.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

// 该类完成登录验证和用户注册，准备发送对象给服务器端
public class UserClientService {

   private User user = new User();

   private Socket socket;

   // 退出客户端，并且给服务器发送一个退出系统的 Message 对象
   public void logout(){
      Message message = new Message();
      message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
      message.setSender(user.getUserId()); //一定要指定是哪个客户端
      // 发送 Message
      try {
         ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
         oos.writeObject(message);
         System.out.println(user.getUserId() + " 退出了系统");
         System.exit(0); //退出进程
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // 向服务器端请求 在线列表
   public void onLineFriend(){
      //发送一个 Message 类型是请求在线用户
      Message message = new Message();
      message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
      message.setSender(user.getUserId());

      //发送一个Message 对象给服务器，要在线用户列表
      try {
         //先根据 用户的id 获取到 Socket，在获取到输出流
         ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId());
         ObjectOutputStream outputStream = new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
         outputStream.writeObject(message);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // 向服务器验证 根据 用户id 和 密码验证用户是否合法
   public boolean checkUser(String userId,String pwd){
      boolean b = false;
      user.setUserId(userId);
      user.setPassWord(pwd);
      // 连接到服务端，发送 user 对象
      try {
         socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
         ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
         outputStream.writeObject(user); //发送 user 对象都服务端

         // 从服务器读取 回复的 Message 对象
         ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
         Message message = (Message) inputStream.readObject();

         //登录成功，创建一个和服务器端保持通讯的线程
         if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            // 创建一个线程类，将 Socket 交给 ClientConnectServerThread 去管理
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();
            // 这里为了客户端的扩展，将线程放入到集合中
            ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
            b = true;
         }else{
            // 不能启动和服务器通讯的线程，关闭 Socket
            socket.close();
         }
      }catch (Exception e){
         e.printStackTrace();
      }
      return b;
   }
}
