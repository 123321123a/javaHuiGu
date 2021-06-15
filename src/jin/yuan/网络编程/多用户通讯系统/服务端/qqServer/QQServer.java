package jin.yuan.网络编程.多用户通讯系统.服务端.qqServer;

import jin.yuan.网络编程.多用户通讯系统.共有的.Message;
import jin.yuan.网络编程.多用户通讯系统.共有的.MessageType;
import jin.yuan.网络编程.多用户通讯系统.共有的.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

//监听端口，等到客户端的连接，并保持通讯
@SuppressWarnings({"all"})
public class QQServer {
   private ServerSocket ss = null;

   //创建一个用户的集合，模拟数据库
   private static HashMap<String, User> validUsers = new HashMap<>();

   static {
      validUsers.put("100",new User("100","123456"));
      validUsers.put("200",new User("200","123456"));
      validUsers.put("300",new User("300","123456"));
      validUsers.put("400",new User("400","123456"));
      validUsers.put("500",new User("500","123456"));
      validUsers.put("600",new User("600","123456"));
   }

   //验证用户是否有效
   private boolean checkUser(String userId,String pwd){
      User user = validUsers.get(userId);
      if (user == null) return false;
      if (!user.getPassWord().equals(pwd)) return false;
      return true;
   }

   public QQServer(){
      try {
         System.out.println("9999 端口在监听...");
         ss = new ServerSocket(9999);
         //监听是循环的，当和某个客户端建立连接后会继续监听，因此是 while 循环
         while (true){
            Socket socket = ss.accept();
            // 得到连接到的 User 对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            User user = (User)ois.readObject();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Message message = new Message(); // 准备回复客户端
            if (checkUser(user.getUserId(),user.getPassWord())){
               System.out.println("检查通过，登录成功...  " + user.toString());
               message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
               oos.writeObject(message);
               //创建一个线程和客户端保持通讯，该线程需要持有 Socket 对象
               ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
               serverConnectClientThread.start();
               //把该线程对象发入到集合中进行管理
               ManageClientThreads.addClientThread(user.getUserId(),serverConnectClientThread);
            }else{
               System.out.println("用户" + user.toString() + "  登录失败...");
               message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
               oos.writeObject(message);
               socket.close();
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         // 退出了 while 循环说明服务端不再监听，因此关 ServetSocket
         try {
            ss.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}


















